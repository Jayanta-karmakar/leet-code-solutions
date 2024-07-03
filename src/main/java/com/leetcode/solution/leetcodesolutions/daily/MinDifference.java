package com.leetcode.solution.leetcodesolutions.daily;

import java.util.Arrays;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 03/07/24, Wednesday
 **/

public class MinDifference {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        minDifference = Math.min(minDifference, nums[n - 4] - nums[0]);
        minDifference = Math.min(minDifference, nums[n - 3] - nums[1]);
        minDifference = Math.min(minDifference, nums[n - 2] - nums[2]);
        minDifference = Math.min(minDifference, nums[n - 1] - nums[3]);

        return minDifference;
    }

    public static void main(String[] args) {
        MinDifference solution = new MinDifference();
        int[] nums = {1, 5, 0, 10, 14, 1};
        System.out.println(solution.minDifference(nums));  // Output: 1
    }
}
