package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 01/10/24, Tuesday
 **/

@Slf4j
public class canArrange {

    public boolean solution(int[] arr, int k) {
        // Create an array to store frequency of remainders
        int[] remainderCount = new int[k];

        // Calculate the remainder of each element and store their frequency
        for (int num : arr) {
            int remainder = num % k;
            // Handle negative remainders by adjusting them
            if (remainder < 0) {
                remainder += k;
            }
            remainderCount[remainder]++;
        }

        // Check if pairs can be formed
        for (int i = 1; i < k; i++) {
            // For remainder i, we need remainder (k - i)
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }

        // Special case: remainder 0 must be even (pairs with itself)
        return remainderCount[0] % 2 == 0;
    }
}
