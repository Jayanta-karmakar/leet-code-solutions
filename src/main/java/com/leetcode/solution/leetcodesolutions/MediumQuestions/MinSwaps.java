package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 08/10/24, Tuesday
 **/

@Slf4j
public class MinSwaps {

    public static int minSwaps(String s) {
        int balance = 0;
        int maxImbalance = 0;

        // Traverse through the string
        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance--; // Opening bracket improves balance
            } else {
                balance++; // Closing bracket worsens balance
            }

            // Record the maximum imbalance
            maxImbalance = Math.max(maxImbalance, balance);
        }

        // Minimum swaps needed is half of the max imbalance
        return (maxImbalance + 1) / 2;
    }

    public static void main(String[] args) {
        String string = "][][";
        log.info("Output : {}", minSwaps(string));
    }
}
