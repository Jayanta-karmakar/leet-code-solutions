package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 15/10/24, Tuesday
 **/

@Slf4j
public class MinimumSteps {
    public static long minimumSteps(String s) {
        long ans = 0;
        int blackCount = 0; // Tracks the number of black balls (1s)

        // Traverse through the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                // White ball encountered, add the number of black balls on its left
                ans += blackCount;
            } else {
                // Black ball encountered, increment the black ball count
                blackCount++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "100";
        log.info("Output : {}", minimumSteps(s));
    }
}
