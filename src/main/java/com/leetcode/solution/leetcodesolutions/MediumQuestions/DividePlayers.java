package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 04/10/24, Friday
 **/

@Slf4j
public class DividePlayers {
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);  // Sort the skills to easily form valid pairs
        int n = skill.length;
        long totalChemistry = 0;

        // The total skill of each team must be the same
        int targetSum = skill[0] + skill[n - 1];

        for (int i = 0; i < n / 2; i++) {
            int currentSum = skill[i] + skill[n - i - 1];

            // If the sum of the current pair is not equal to the target sum, return -1
            if (currentSum != targetSum) {
                return -1;
            }

            // Calculate the chemistry for the current team and add it to the total
            totalChemistry += (long) skill[i] * skill[n - i - 1];
        }

        return totalChemistry;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,1,3,4};
        log.info("Output : {}", dividePlayers(arr));
    }
}
