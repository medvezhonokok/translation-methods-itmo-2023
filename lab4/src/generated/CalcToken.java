package generated;
public enum CalcToken {
	NUMBER$(""), PLUS("+"), MINUS("-"), MULTIPLY$("*"), DIVIDE("/"), LPAREN("("), RPAREN(")"), END("eof"), VARIABLE(""), OP_CORN_BR("<"), CLOSE_CORN_BR(">"), NUMBER1("");

    private String tokenValue;

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getTokenValue() {
        return switch (this) {
            case NUMBER$, VARIABLE -> this.tokenValue;
            default -> this.name();
        };
    }

    CalcToken(String tokenValue) {
        this.tokenValue = tokenValue;
    }
}
