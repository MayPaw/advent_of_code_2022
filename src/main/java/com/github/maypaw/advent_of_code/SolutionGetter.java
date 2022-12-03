package com.github.maypaw.advent_of_code;

import com.github.maypaw.advent_of_code.data.Data;
import com.github.maypaw.advent_of_code.data.day1.DataProcessor;
import com.github.maypaw.advent_of_code.data.day1.Elf;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SolutionGetter {

    private SolutionGetter() {

    }

    public static Long getDayOnePartOneSolution() {
        List<Elf> elves = DataProcessor.getProcessedData(Data.ALL_CALORIES);
        Optional<Elf> maxCalories = elves.stream()
                                         .max(Comparator.comparing(Elf::getCaloriesSum));

        return maxCalories.orElse(new Elf(List.of(0L)))
                          .getCaloriesSum();
    }

    public static Long getDayOnePartTwoSolution() {
        List<Elf> elves = DataProcessor.getProcessedData(Data.ALL_CALORIES);
        return elves.stream()
                                   .sorted(Comparator.comparing(Elf::getCaloriesSum)
                                                     .reversed())
                                   .limit(3)
                                   .mapToLong(Elf::getCaloriesSum)
                                   .reduce(Long::sum).orElse(0);
    }

}
