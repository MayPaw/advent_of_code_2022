package com.github.maypaw.advent_of_code.day2;

import static com.github.maypaw.advent_of_code.day2.RockPaperScissors.*;

public enum OpponentMove {
    A(ROCK, 1L, "C", "B"),

    B(PAPER, 2L, "A", "C"),

    C(SCISSORS, 3L, "B", "A");

    public final RockPaperScissors moveName;
    public final String winsWith;
    public final String losesWith;
    public final Long points;

    private OpponentMove(RockPaperScissors moveName,
                         Long points,
                         String winsWith,
                         String losesWith) {
        this.moveName = moveName;
        this.points = points;
        this.winsWith = winsWith;
        this.losesWith = losesWith;
    }
}
