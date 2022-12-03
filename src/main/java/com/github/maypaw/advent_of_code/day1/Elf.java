package com.github.maypaw.advent_of_code.day1;

import lombok.Getter;

import java.util.List;

@Getter
public class Elf {

    private final List<Long> calories;
    private final Long caloriesSum;

    public Elf(List<Long> calories) {
        this.calories = calories;
        this.caloriesSum = countCaloriesSum();
    }

    private Long countCaloriesSum() {
        return calories.stream()
                       .reduce(Long::sum)
                       .orElse(0L);
    }

}
