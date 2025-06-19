package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import java.util.Arrays;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 19/06/25, Thursday
 **/


public class MaximumSubarray {

//    public static int maxSubArray(int[] nums) {
//        int length = nums.length;
//        int maxNUm = Integer.MIN_VALUE;
//        for (int i = 0; i < length; i++) {
//            int sum = 0;
//            for (int j = i; j < length; j++) {
//                sum += nums[j];
//                maxNUm = Math.max(sum, maxNUm);
//            }
//        }
//        return maxNUm;
//    }

    public static int maxSubArray(int[] nums) {
        int maxNUm = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxNUm) {
                maxNUm = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return maxNUm;
    }

    public static void main(String args[]) {
        int[] question = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int res = maxSubArray(question);
        System.out.println("Question : " + Arrays.toString(question));
        System.out.println("Answer : " + res);
    }
}
