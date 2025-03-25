package com.leetcode.solution.leetcodesolutions.easyQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 25/03/25, Tuesday
 **/

@Slf4j
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        log.info("Nums: {}", Arrays.toString(nums));
        log.info("Result: {}", searchInsert(nums, 2));
    }
}
