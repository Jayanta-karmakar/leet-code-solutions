package com.leetcode.solution.leetcodesolutions.easyQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 19/02/24, Monday
 **/

@Slf4j
public class isPalindrome {
    public static boolean palindrome(int x) {
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        log.info("Output : {}", palindrome(-123));
    }
}
