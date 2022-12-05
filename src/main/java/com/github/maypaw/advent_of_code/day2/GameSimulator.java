package com.github.maypaw.advent_of_code.day2;

import java.util.Arrays;
import java.util.Objects;

import static com.github.maypaw.advent_of_code.day2.GameState.*;

public class GameSimulator {

    private GameSimulator() {

    }

    public static Long getPlayerTotalScore(String[][] winningScheme) {
        validateScheme(winningScheme);
        return Arrays.stream(winningScheme)
                     .map(GameSimulator::countPlayerPoints)
                     .reduce(0L, Long::sum);
    }

    public static Long getPlannedPlayerTotalScore(String[][] winningScheme) {
        validateScheme(winningScheme);
        return Arrays.stream(winningScheme)
                     .map(GameSimulator::countPlannedPlayerPoints)
                     .reduce(0L, Long::sum);
    }

    private static Long countPlannedPlayerPoints(String[] round) {
        if (Goal.valueOf(round[1]).type.equals(VICTORY)) {
            String winningOption = OpponentMove.valueOf(round[0]).losesWith;
            return OpponentMove.valueOf(winningOption).points + VICTORY.points;
        }

        if (Goal.valueOf(round[1]).type.equals(DEFEAT)) {
            String losingOption = OpponentMove.valueOf(round[0]).winsWith;
            return OpponentMove.valueOf(losingOption).points;
        }

        return OpponentMove.valueOf(round[0]).points + DRAW.points;
    }

    private static Long countPlayerPoints(String[] round) {
        GameState gameState = getGameState(round);
        if (gameState.equals(VICTORY)) {
            return Move.valueOf(round[1]).points + VICTORY.points;
        }

        if (gameState.equals(DEFEAT)) {
            return Move.valueOf(round[1]).points;
        }

        return Move.valueOf(round[1]).points + DRAW.points;
    }

    private static void validateScheme(String[][] winningScheme) {
        Arrays.stream(winningScheme)
              .forEach(round -> {
                  if (Objects.isNull(round) || round.length != 2) {
                      throw new IllegalArgumentException("Given winningScheme does not meet required format: [][]");
                  }
              });
    }

    private static GameState getGameState(String[] round) {
        if (Move.valueOf(round[0]).moveName.equals(Move.valueOf(round[1]).moveName)) {
            return DRAW;
        }

        if (Move.valueOf(round[0]).winsWith.equals(Move.valueOf(round[1]).moveName)) {
            return DEFEAT;
        }

        return VICTORY;
    }

}
