package lab4.model;

import lab4.utils.CollectionUtil;
import lab4.utils.StringUtil;

import javax.annotation.Nullable;
import java.util.*;

public class Grammar {
    private final Map<String, String> tokenToValueMap;
    private final Map<String, List<List<String>>> stateToSubsequentState;
    private final List<String> grammar;
    private final Set<String> tokens;
    private final Set<String> nonTerminals;
    private static Map<String, Set<String>> FIRST;
    private static Map<String, Set<String>> FOLLOW;
    private final Map<String, String> NESTED;

    public Grammar(List<String> states, String tokenDeclaration, String nested) {
        this.NESTED = new HashMap<>();
        this.grammar = CollectionUtil.getNonEmptyTrimmedStringList(states);
        this.stateToSubsequentState = new HashMap<>();
        this.tokens = new HashSet<>();
        this.nonTerminals = new HashSet<>();
        this.tokenToValueMap = new HashMap<>();

        if (StringUtil.isNotNullOrBlank(nested)) {
            nested = nested.replaceAll("#NESTED#", "");
            String[] parts = nested.split("=-=-=");

            for (String tokenToNested : parts) {
                String[] split = tokenToNested.split("-----");
                if (split.length != 2) {
                    throw new RuntimeException("Bad nested token parts declaration: " + tokenToNested);
                } else {
                    NESTED.put(split[0], split[1]);
                }
            }
        }

        for (String tokenAndValue : tokenDeclaration.split("=-=-=")) {
            String[] parts = tokenAndValue.split("-----");
            if (parts.length != 2) {
                throw new InputMismatchException("Bad tokens declaration: {" + Arrays.toString(parts) + "}");
            } else {
                tokens.add(parts[0]);
                tokenToValueMap.put(parts[0], parts[1]);
            }
        }

        for (String state : getGrammar()) {
            String[] parts = state.split("->");
            if (parts.length == 3) {
                String fromState = parts[0];
                List<String> toStates = Arrays.stream(parts[1].split("\\s+"))
                        .filter(StringUtil::isNotNullOrBlank)
                        .toList();

                stateToSubsequentState.putIfAbsent(fromState, new ArrayList<>());
                stateToSubsequentState.get(fromState).add(toStates);

                if (!fromState.startsWith("_")) {
                    nonTerminals.add(fromState.trim());
                }
            } else {
                throw new IllegalArgumentException("Unexpected grammar state: " + state);
            }
        }

        FIRST = calculateFirst();
        FOLLOW = calculateFollow();
    }

    public static Map<String, Set<String>> getFIRST() {
        return FIRST;
    }

    public static Map<String, Set<String>> getFOLLOW() {
        return FOLLOW;
    }

    private Map<String, Set<String>> calculateFirst() {
        Map<String, Set<String>> first = new HashMap<>();

        for (String nonTerminal : nonTerminals) {
            first.put(nonTerminal, new HashSet<>());
        }

        boolean changed;
        do {
            changed = false;
            for (String state : getGrammar()) {
                String[] parts = state.split("->");
                String fromState = parts[0].trim();
                List<String> toStates = CollectionUtil.getNonEmptyTrimmedStringList(
                        Arrays.stream(parts[1].split("\\s+")).toList());

                for (String symbol : toStates) {
                    if (tokens.contains(symbol) || symbol.startsWith("_")) {
                        if (symbol.startsWith("_")) symbol = symbol.substring(1);
                        changed |= first.get(fromState).add(symbol);
                        break;
                    } else {
                        Set<String> symbolsFirst = first.get(symbol);
                        boolean hasEpsilon = symbolsFirst.contains("");

                        changed |= first.get(fromState).addAll(symbolsFirst);
                        if (!hasEpsilon) {
                            break;
                        }
                    }
                }
            }
        } while (changed);

        return first;
    }

    public Map<String, Set<String>> calculateFollow() {
        Map<String, Set<String>> follow = new HashMap<>();

        for (String nonTerminal : nonTerminals) {
            follow.put(nonTerminal, new HashSet<>());
        }

        follow.get(getGrammar().get(0).split("->")[0].trim()).add("$");

        boolean changed;
        do {
            changed = false;
            for (String state : getGrammar()) {
                String[] parts = state.split("->");
                String fromState = parts[0].trim();
                List<String> toStates = CollectionUtil.getNonEmptyTrimmedStringList(
                        Arrays.stream(parts[1].split("\\s+")).toList());

                for (int i = 0; i < toStates.size(); i++) {
                    String symbol = toStates.get(i);
                    if (nonTerminals.contains(symbol)) {
                        boolean epsilonExists = true;
                        for (int j = i + 1; j < toStates.size(); j++) {
                            String nextSymbol = toStates.get(j);
                            if (tokens.contains(nextSymbol)) {
                                changed |= follow.get(symbol).add(nextSymbol);
                                epsilonExists = false;
                                break;
                            } else if (nonTerminals.contains(nextSymbol)) {
                                Set<String> nextFirst = new HashSet<>(calculateFirst().get(nextSymbol));
                                boolean hasEpsilon = nextFirst.remove("");

                                changed |= follow.get(symbol).addAll(nextFirst);
                                if (!hasEpsilon) {
                                    epsilonExists = false;
                                    break;
                                }
                            }
                        }

                        if (epsilonExists) {
                            changed |= follow.get(symbol).addAll(follow.get(fromState));
                        }
                    }
                }
            }
        } while (changed);

        return follow;
    }


    public boolean isLL1Grammar() {
        Map<String, Set<String>> firstSets = calculateFirst();

        for (String state : grammar) {
            String[] parts = state.split("->");

            String fromState = parts[0].trim();
            List<String> toStates = CollectionUtil.getNonEmptyTrimmedStringList(
                    Arrays.asList(parts[1].split("\\s+")));

            Set<String> intersection = new HashSet<>(firstSets.getOrDefault(toStates.get(0), new HashSet<>()));

            if (toStates.size() > 1) {
                intersection.retainAll(firstSets.getOrDefault(toStates.get(1), new HashSet<>()));
            } else {
                if (intersection.contains("") && !toStates.get(0).equals("_END")) {
                    Set<String> follow = calculateFollow().get(fromState);
                    intersection = new HashSet<>(follow);
                }
            }

            if (!intersection.isEmpty()) {
                return false;
            }
        }

        return true;
    }


    public List<String> getGrammar() {
        return grammar;
    }

    public Map<String, String> getTokenToValueMap() {
        return tokenToValueMap;
    }

    @Nullable
    public String getTokenValue(String tokenName) {
        return tokenToValueMap.get(tokenName);
    }

    public Map<String, List<List<String>>> getStateToSubsequentState() {
        return stateToSubsequentState;
    }

    public Set<String> getTokens() {
        return tokens;
    }

    public Set<String> getNonTerminals() {
        return nonTerminals;
    }

    public Map<String, String> getNESTED() {
        return NESTED;
    }
}
