package com.leetcode.solution.leetcodesolutions.easyQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 20/02/24, Tuesday
 **/

@Slf4j
public class isPowerOfTwo {
    public static boolean powerOfTwo(int n) {
        if (n > 0) {
            return  (n & (n - 1)) == 0;
        }
         return false;
    }

    public static void main(String[] args) {
        log.info("Output : {}", powerOfTwo(16));
    }
}
