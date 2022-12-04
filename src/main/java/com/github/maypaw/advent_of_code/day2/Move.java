package com.github.maypaw.advent_of_code.day2;

import static com.github.maypaw.advent_of_code.day2.RockPaperScissors.*;

public enum Move {

    X(ROCK, 1L, SCISSORS, PAPER),

    Y(PAPER, 2L, ROCK, SCISSORS),

    Z(SCISSORS, 3L, PAPER, ROCK),

    A(ROCK, 1L, SCISSORS, PAPER),

    B(PAPER, 2L, ROCK, SCISSORS),

    C(SCISSORS, 3L, PAPER, ROCK);

    public final RockPaperScissors moveName;
    public final RockPaperScissors winsWith;
    public final RockPaperScissors losesWith;
    public final Long points;

    private Move(RockPaperScissors moveName,
                 Long points,
                 RockPaperScissors winsWith,
                 RockPaperScissors losesWith) {
        this.moveName = moveName;
        this.points = points;
        this.winsWith = winsWith;
        this.losesWith = losesWith;
    }
}
