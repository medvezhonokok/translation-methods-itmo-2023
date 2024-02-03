# **Invariants:**

- For each state, if a token exists, it is unique and occupies the first position.

- In all states of any given state 'x', if at least one state of 'x' contains a token in the first position, then all other states of 'x' also have tokens in the first positions.

- In the grammar, if a state 'x' lacks a token in any of its states, 'x' has only one state.

# **Special Effects:**

- "_" signifies inputting a new symbol at the beginning of the method.

- "\$" signifies inputting a new symbol after switch-cases.
