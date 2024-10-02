package com.leetcode.solution.leetcodesolutions.daily;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 03/10/24, Thursday
 **/

@Slf4j
public class ArrayRankTransform {

    public static int[] arrayRankTransform(int[] arr) {
        // Step 1: Create a copy of the original array and sort it
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Step 2: Create a HashMap to map elements to their rank
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // Step 3: Assign ranks to the sorted elements
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        // Step 4: Replace elements in the original array with their ranks
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {40,10,20,30};
        log.info("Output : {}", arrayRankTransform(arr));
    }
}

