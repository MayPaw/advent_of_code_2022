package com.github.maypaw.advent_of_code;

import com.github.maypaw.advent_of_code.day1.MaximumCaloriesFinder;
import com.github.maypaw.advent_of_code.day2.GameSimulator;
import com.github.maypaw.advent_of_code.day2.SchemeProcessor;
import com.github.maypaw.advent_of_code.day2.WinningScheme;

public class SolutionRunner {

    public static void main(String[] args) {
        System.out.println("Day 1 part 1 solution: " + MaximumCaloriesFinder.findMaxCaloriesSumPerElf());
        System.out.println("Day 1 part 2 solution: " + MaximumCaloriesFinder.findTopThreeCaloriesSumsPerElf());
        System.out.println("Day 2 part 1 solution: " + GameSimulator.getPlayerTotalScore(
                SchemeProcessor.getProcessedData(WinningScheme.CONTENT)));
    }

}
