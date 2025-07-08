package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 08/07/25, Tuesday
 **/

@Slf4j
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add current subset

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
