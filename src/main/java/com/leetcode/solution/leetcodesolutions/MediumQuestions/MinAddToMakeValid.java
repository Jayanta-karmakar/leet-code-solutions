package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 09/10/24, Wednesday
 **/

@Slf4j
public class MinAddToMakeValid {
    public static int minAddToMakeValid(String s) {
        int open = 0, close = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++; // An unmatched opening parenthesis
            } else if (open > 0) {
                open--; // Match this closing parenthesis with an opening one
            } else {
                close++; // An unmatched closing parenthesis
            }
        }

        // The result is the sum of unmatched open and close parentheses
        return open + close;
    }

    public static void main(String[] args) {
        String string = "())";
        log.info("Output : {}", minAddToMakeValid(string));
    }
}
