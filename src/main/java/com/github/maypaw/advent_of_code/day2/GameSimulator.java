package com.github.maypaw.advent_of_code.day2;

import java.util.Arrays;
import java.util.Objects;

import static com.github.maypaw.advent_of_code.day2.GameState.*;

public class GameSimulator {

    private GameSimulator() {

    }

    public static Long getPlayerTotalScore(Move[][] winningScheme) {
        validateScheme(winningScheme);
        return Arrays.stream(winningScheme)
                     .map(GameSimulator::countPlayerPoints)
                     .reduce(0L, Long::sum);
    }

    private static Long countPlayerPoints(Move[] round) {
        GameState gameState = getGameState(round);
        if (gameState.equals(VICTORY)) {
            return round[1].points + VICTORY.points;
        }

        if (gameState.equals(DEFEAT)) {
            return round[1].points;
        }

        return round[1].points + DRAW.points;
    }

    private static void validateScheme(Move[][] winningScheme) {
        Arrays.stream(winningScheme)
              .forEach(round -> {
                  if (Objects.isNull(round) || round.length != 2) {
                      throw new IllegalArgumentException("Given winningScheme does not meet required format: [][]");
                  }
              });
    }

    private static GameState getGameState(Move[] round) {
        if (round[0].moveName.equals(round[1].moveName)) {
            return DRAW;
        }

        if (round[0].winsWith.equals(round[1].moveName)) {
            return DEFEAT;
        }

        return VICTORY;
    }

}
