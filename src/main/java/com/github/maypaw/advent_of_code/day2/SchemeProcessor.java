package com.github.maypaw.advent_of_code.day2;

import java.util.Arrays;

public class SchemeProcessor {

    private SchemeProcessor() {

    }

    public static String[][] getProcessedData(String scheme) {
        return Arrays.stream(scheme.split("\n"))
                     .map(SchemeProcessor::getMoves)
                     .toArray(String[][]::new);
    }

    private static String[] getMoves(String round) {
        return round.split("\s");
    }

}
