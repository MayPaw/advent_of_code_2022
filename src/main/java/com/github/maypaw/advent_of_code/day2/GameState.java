package com.github.maypaw.advent_of_code.day2;

public enum GameState {
    VICTORY(6L),
    DRAW(3L),
    DEFEAT(0L);

    public final Long points;

    private GameState(Long points) {
        this.points = points;
    }
}
