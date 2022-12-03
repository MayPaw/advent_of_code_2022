package com.github.maypaw.advent_of_code.day1;

import java.util.Arrays;
import java.util.List;

public class CaloriesPerElfProcessor {

    private CaloriesPerElfProcessor() {

    }

    public static List<Elf> getProcessedData(String allCalories) {
        return Arrays.stream(getCaloriesPerElfAsTextBlock(allCalories))
                     .map(block -> new Elf(getCaloriesTextBlockAsNumberCollection(block)))
                     .toList();
    }

    private static String[] getCaloriesPerElfAsTextBlock(String allCalories) {
        return allCalories.split("\n\n");
    }

    private static List<Long> getCaloriesTextBlockAsNumberCollection(String singleElfCaloriesBlock) {
        return Arrays.stream(singleElfCaloriesBlock.split("\n"))
                     .map(Long::parseLong)
                     .toList();
    }

}
