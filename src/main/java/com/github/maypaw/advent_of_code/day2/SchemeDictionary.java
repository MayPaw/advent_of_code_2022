package com.github.maypaw.advent_of_code.day2;

public enum SchemeDictionary {

    PLAYER_ROCK_WIN("X", 1),

    PLAYER_PAPER_WIN("Y", 2),

    PLAYER_SCISSORS_WIN("Z", 3),

    OPPONENT_ROCK_WIN("A", 1),

    OPPONENT_PAPER_WIN("B", 2),

    OPPONENT_SCISSORS_WIN("C", 3);

    public final String symbol;
    public final Integer points;

    private SchemeDictionary(String symbol, Integer points) {
        this.symbol = symbol;
        this.points = points;
    }
}
