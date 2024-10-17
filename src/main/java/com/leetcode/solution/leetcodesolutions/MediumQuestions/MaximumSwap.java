package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 17/10/24, Thursday
 **/

@Slf4j
public class MaximumSwap {
    public static int maximumSwap(int num) {
        // Convert the number to a character array
        char[] digits = Integer.toString(num).toCharArray();

        // Store the last occurrence of each digit
        int[] lastIndex = new int[10];
        for (int i = 0; i < digits.length; i++) {
            lastIndex[digits[i] - '0'] = i;
        }

        // Traverse the digits and find the first one to swap
        for (int i = 0; i < digits.length; i++) {
            // Check from 9 to the current digit + 1 for a larger digit
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastIndex[d] > i) {
                    // Swap the current digit with the larger digit found
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;

                    // Convert the array back to an integer and return
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        // If no swap was made, return the original number
        return num;
    }

    public static void main(String[] args) {
        log.info("Output : {}", maximumSwap(2736));
    }
}
