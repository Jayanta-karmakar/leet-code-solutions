package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 19/10/24, Saturday
 **/

@Slf4j
public class FindKthBit {
    public static char findKthBit(int n, int k) {
        // Base case: S1 is "0"
        if (n == 1) {
            return '0';
        }

        // Calculate the midpoint of Sn
        int mid = (1 << (n - 1)); // This is 2^(n-1)

        // If k is the midpoint, return '1'
        if (k == mid) {
            return '1';
        }

        // If k is less than the midpoint, recurse on the first half (Sn-1)
        if (k < mid) {
            return findKthBit(n - 1, k);
        }

        // If k is greater than the midpoint, find the corresponding bit in the reverse and invert part
        // Recurse for the corresponding position in Sn-1
        char bit = findKthBit(n - 1, mid - (k - mid));

        // Invert the bit: '0' becomes '1', '1' becomes '0'
        return bit == '0' ? '1' : '0';
    }

    public static void main(String[] args) {
        log.info("Output : {}", findKthBit(3, 1));
    }
}
