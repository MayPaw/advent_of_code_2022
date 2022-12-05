package com.github.maypaw.advent_of_code.day2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SchemeProcessorTest {

    @Test
    void shouldReturnDataInTwoDimensionalArrayScheme_WhenGettingProcessedData() {
        // given
        String scheme = """
                        A X
                        C Y
                        B Z
                        """;
        String[][] expectedScheme = {{"A", "X"}, {"C", "Y"}, {"B", "Z"}};

        // when
        String[][] processedData = SchemeProcessor.getProcessedData(scheme);

        // then
        assertThat(processedData).isEqualTo(expectedScheme);
    }

    @Test
    void shouldThrowIllegalArgumentException_WhenEmptySchemeGiven() {
        // given
        String scheme = """
                        """;

        // when / then
        assertThatThrownBy(() -> SchemeProcessor.getProcessedData(scheme)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowIllegalArgumentException_WhenSchemeWithContentDifferentThanMoveEnumNamesGiven() {
        // given
        String scheme = """
                        A Content
                        C Y
                        B Z
                        """;

        // when / then
        assertThatThrownBy(() -> SchemeProcessor.getProcessedData(scheme)).isInstanceOf(IllegalArgumentException.class);
    }

}