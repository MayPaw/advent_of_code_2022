package com.github.maypaw.advent_of_code.day2;

import java.util.Arrays;

public class SchemeProcessor {

    private SchemeProcessor() {

    }

    public static Move[][] getProcessedData(String scheme) {
        return Arrays.stream(scheme.split("\n"))
                     .map(SchemeProcessor::getMoves)
                     .toArray(Move[][]::new);
    }

    private static Move[] getMoves(String round) {
        return Arrays.stream(round.split("\s"))
                     .map(Move::valueOf)
                     .toArray(Move[]::new);
    }

}
