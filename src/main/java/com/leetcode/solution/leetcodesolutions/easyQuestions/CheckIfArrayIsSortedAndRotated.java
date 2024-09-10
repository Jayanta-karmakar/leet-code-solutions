package com.leetcode.solution.leetcodesolutions.easyQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 09/09/24, Monday
 **/

@Slf4j
public class CheckIfArrayIsSortedAndRotated {

    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int a = nums[i];
            int b = nums[(i + 1) % n];
            if (a > b) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        log.info("Output : {}", check(arr));
    }
}
