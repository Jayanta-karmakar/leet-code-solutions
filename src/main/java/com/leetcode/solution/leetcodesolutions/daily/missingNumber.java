package com.leetcode.solution.leetcodesolutions.daily;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 20/02/24, Tuesday
 **/

@Slf4j
public class missingNumber {
    public static int missingNumberCheck(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lengthOfNum = nums.length;
        int missingNumber = lengthOfNum;
        for (int i = 0; i < lengthOfNum; i++) {
            missingNumber ^= i ^ nums[i];
            log.info("First Approach : {}", missingNumber);
        }
        return missingNumber;
    }

    public static int missingNumberCheckSecondApproach(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        log.info("Expected Sum : {}", expectedSum);
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
            log.info("Loop : {}", actualSum);
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        log.info("input : {}", nums);
        log.info("First Approach Output : {}", missingNumberCheck(nums));
        log.info("Second Approach Output : {}", missingNumberCheckSecondApproach(nums));
    }
}
