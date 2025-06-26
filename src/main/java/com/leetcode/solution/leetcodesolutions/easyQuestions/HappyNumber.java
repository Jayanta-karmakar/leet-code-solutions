package com.leetcode.solution.leetcodesolutions.easyQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 25/06/25, Wednesday
 **/
public class HappyNumber {

    public boolean isHappy(int n) {
        // Use a set to detect cycles (repeated numbers)
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    // Helper method to calculate the sum of squares of digits
    private int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10; // get last digit
            sum += digit * digit; // add square of digit
            num /= 10; // remove last digit
        }
        return sum;
    }

    public static void main(String args[]) {
        HappyNumber happyNumber = new HappyNumber();
        int happyNumbers = 19; // Example number to check
        boolean result = happyNumber.isHappy(happyNumbers);
        System.out.println("Is " + happyNumbers + " a happy number? " + result);
    }
}
