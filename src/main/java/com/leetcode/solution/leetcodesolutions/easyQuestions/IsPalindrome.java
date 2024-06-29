package com.leetcode.solution.leetcodesolutions.easyQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * A class that contains a method to check if a number is a palindrome.
 * A palindrome is a number that reads the same forward and backward.
 * <p>
 * Example usage:
 * {@code PalindromeChecker.isPalindrome(121);} // returns true
 * {@code PalindromeChecker.isPalindrome(-121);} // returns false
 * </p>
 * <p>
 * Created by jayantakarmakar on 19/02/24, Monday.
 * </p>
 */
@Slf4j
public class IsPalindrome {

    /**
     * Checks if the given integer is a palindrome.
     *
     * @param x the integer to check
     * @return true if the integer is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int x) {
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
        int testNumber = -123;
        boolean result = isPalindrome(testNumber);
        log.info("Is the number {} a palindrome? {}", testNumber, result);
    }
}
