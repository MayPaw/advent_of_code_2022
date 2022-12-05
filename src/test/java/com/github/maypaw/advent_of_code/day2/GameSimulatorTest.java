package com.github.maypaw.advent_of_code.day2;

import org.junit.jupiter.api.Test;

import static com.github.maypaw.advent_of_code.day2.GameState.DRAW;
import static com.github.maypaw.advent_of_code.day2.GameState.VICTORY;
import static com.github.maypaw.advent_of_code.day2.Move.X;
import static com.github.maypaw.advent_of_code.day2.Move.Y;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameSimulatorTest {

    @Test
    void shouldReturnValidSum_WhenCountingPlayerPoints() {
        // given
        String[][] scheme = {{"A", "Y"}, {"B", "X"}, {"C", "Z"}};
        Long expectedScore = 15L;

        // when
        Long playerTotalScore = GameSimulator.getPlayerTotalScore(scheme);

        // then
        assertThat(playerTotalScore).isEqualTo(expectedScore);

    }

    @Test
    void shouldReturnZero_WhenGivenEmptyScheme() {
        // given
        String[][] scheme = {};
        // when
        Long playerTotalScore = GameSimulator.getPlayerTotalScore(scheme);

        // then
        assertThat(playerTotalScore).isZero();
    }

    @Test
    void shouldAddVictoryPointsToMovePoints_WhenGameStateIsVictory() {
        // given
        String[][] scheme = {{"A", "Y"}};
        Long expectedScore = Y.points + VICTORY.points;

        // when
        Long playerTotalScore = GameSimulator.getPlayerTotalScore(scheme);

        // then
        assertThat(playerTotalScore).isEqualTo(expectedScore);
    }

    @Test
    void shouldAddDrawPointsToMovePoints_WhenGameStateIsDefeat() {
        // given
        String[][] scheme = {{"A", "X"}};
        Long expectedScore = X.points + DRAW.points;

        // when
        Long playerTotalScore = GameSimulator.getPlayerTotalScore(scheme);

        // then
        assertThat(playerTotalScore).isEqualTo(expectedScore);

    }

    @Test
    void shouldAddNoPointsToMovePoints_WhenGameStateIsDefeat() {
        // given
        String[][] scheme = {{"B", "X"}};
        Long expectedScore = X.points;

        // when
        Long playerTotalScore = GameSimulator.getPlayerTotalScore(scheme);

        // then
        assertThat(playerTotalScore).isEqualTo(expectedScore);

    }

    @Test
    void shouldThrowIllegalArgumentException_WhenGivenSchemeHasInvalidFormat() {
        // given
        String[][] scheme = {{"A", "B"}, {"A", "B", "C"}};

        // when / then
        assertThatThrownBy(() -> GameSimulator.getPlayerTotalScore(scheme)).isInstanceOf(IllegalArgumentException.class);
        // then
    }

}