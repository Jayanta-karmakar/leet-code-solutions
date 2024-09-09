package com.leetcode.solution.leetcodesolutions.easyQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 09/09/24, Monday
 **/

@Slf4j
public class LargestElementInArray {

    public static int largest(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int currentElement = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > currentElement) {
                currentElement = arr[i];
            }
        }
        return currentElement;
    }


    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 56, 90};
        log.info("Output : {}", largest(arr));
    }
}
