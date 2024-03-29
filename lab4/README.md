# **Invariants:**

- For each state, if a token exists, it is unique and occupies the first position.

- In all states of any given state 'x', if at least one state of 'x' contains a token in the first position, then all other states of 'x' also have tokens in the first positions.

- In the grammar, if a state 'x' lacks a token in any of its states, 'x' has only one state.

# **Special Effects:**

- "_" signifies inputting a new symbol at the beginning of the method.

- "\$" signifies inputting a new symbol after switch-cases.

# Упрощенный генератор трансляторов

## Введение
Данный проект представляет собой упрощенный аналог генератора трансляторов, основанный на синтаксисе ANTLR или Bison. В процессе разработки учитываются различные классы грамматик, работа с атрибутами и проводится тестирование.

## Выбор класса грамматик

### 1. LL(1)-грамматики, нисходящий разбор (10 баллов)
Реализована поддержка LL(1)-грамматик с использованием нисходящего разбора.

### 2. SLR-грамматики, восходящий разбор (15 баллов)
Реализована поддержка SLR-грамматик с использованием восходящего разбора.

### 3. LALR-грамматики, восходящий разбор (20 баллов)
Реализована поддержка LALR-грамматик с использованием восходящего разбора.

## Работа с атрибутами

### 4. Поддержка синтезируемых атрибутов (10 баллов)
Добавлена поддержка синтезируемых атрибутов для удобного сбора информации на этапе разбора.

### 5. Поддержка наследуемых атрибутов (10 баллов)
Реализована поддержка наследуемых атрибутов для передачи информации между различными частями разбора.

## Тестирование

### Обязательно
- Сгенерирован калькулятор с использованием данного генератора.

### 6. Выполнить задание второй лабораторной (5 баллов)
Использован генератор для выполнения задания второй лабораторной работы.

### 7. Выполнить задание третьей лабораторной (10 баллов)
Использован генератор для выполнения задания третьей лабораторной работы.
