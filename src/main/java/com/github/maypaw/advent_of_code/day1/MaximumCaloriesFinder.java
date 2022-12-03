package com.github.maypaw.advent_of_code.day1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaximumCaloriesFinder {

    private MaximumCaloriesFinder() {

    }

    public static Long findMaxCaloriesSumPerElf() {
        List<Elf> elves = CaloriesPerElfProcessor.getProcessedData(AllCaloriesData.ALL_CALORIES);
        Optional<Elf> maxCalories = elves.stream()
                                         .max(Comparator.comparing(Elf::getCaloriesSum));

        return maxCalories.orElse(new Elf(List.of(0L)))
                          .getCaloriesSum();
    }

    public static Long findTopThreeCaloriesSumsPerElf() {
        List<Elf> elves = CaloriesPerElfProcessor.getProcessedData(AllCaloriesData.ALL_CALORIES);
        return elves.stream()
                    .sorted(Comparator.comparing(Elf::getCaloriesSum)
                                      .reversed())
                    .limit(3)
                    .mapToLong(Elf::getCaloriesSum)
                    .reduce(Long::sum)
                    .orElse(0);
    }

}
