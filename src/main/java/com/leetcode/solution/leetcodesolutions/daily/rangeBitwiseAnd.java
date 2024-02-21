package com.leetcode.solution.leetcodesolutions.daily;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 21/02/24, Wednesday
 **/

@Slf4j
public class rangeBitwiseAnd {
    public static int rangeBitwiseAndFunction(int left, int right) {
        int num = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            num++;
        }
        return left << num;
    }

    public static void main(String[] args) {
        int left = 5;
        int right = 7;
        System.out.println("left : " + left);
        System.out.println("right : " + right);
        System.out.println("Output : " + rangeBitwiseAndFunction(left, right));
    }
}
