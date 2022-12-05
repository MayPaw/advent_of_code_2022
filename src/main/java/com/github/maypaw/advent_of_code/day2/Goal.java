package com.github.maypaw.advent_of_code.day2;

import static com.github.maypaw.advent_of_code.day2.GameState.*;

public enum Goal {
    X(DEFEAT, 6L),
    Y(DRAW, 3L),
    Z(VICTORY, 0L);

    public final GameState type;
    public final Long points;

    private Goal(GameState type, Long points) {
        this.type = type;
        this.points = points;
    }
}
