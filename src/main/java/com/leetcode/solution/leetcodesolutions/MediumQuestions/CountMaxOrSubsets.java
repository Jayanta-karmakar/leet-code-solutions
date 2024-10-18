package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 18/10/24, Friday
 **/

@Slf4j
public class CountMaxOrSubsets {
    public static int countMaxOrSubsets(int[] nums) {
        // Step 1: Find the maximum possible bitwise OR of all elements
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num; // accumulate the OR of all elements
        }

        // Step 2: Use backtracking to count the number of subsets that achieve maxOr
        return countSubsets(nums, 0, 0, maxOr);
    }

    private static int countSubsets(int[] nums, int index, int currentOr, int maxOr) {
        // If we have processed all elements
        if (index == nums.length) {
            // If the current OR is equal to the max OR, it's a valid subset
            return currentOr == maxOr ? 1 : 0;
        }

        // Include the current element in the subset
        int include = countSubsets(nums, index + 1, currentOr | nums[index], maxOr);

        // Exclude the current element from the subset
        int exclude = countSubsets(nums, index + 1, currentOr, maxOr);

        // Return the total count of valid subsets
        return include + exclude;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2};
        log.info("Output : {}", countMaxOrSubsets(nums));
    }
}
