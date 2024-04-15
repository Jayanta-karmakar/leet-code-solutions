package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.Data;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 15/04/24, Monday
 **/

@Data
public class ReverseInteger {
    public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            int maxValue = Integer.MAX_VALUE;
            int minValue = Integer.MIN_VALUE;
            if (reversed > maxValue / 10 || (reversed == maxValue / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < minValue / 10 || (reversed == minValue / 10 && digit < -8)) {
                return 0;
            }
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int number = 123;
        int reverse = reverse(number);
        System.out.println("Number : " + number);
        System.out.println("reverse : " + reverse);
    }
}
