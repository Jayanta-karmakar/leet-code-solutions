package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 03/10/24, Thursday
 **/

@Slf4j
public class MinSubArray {
    public static int minSubrray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int remainder = (int) (totalSum % p);
        if (remainder == 0) {
            return 0;
        }

        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);

        long prefixSum = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currentMod = (int) (prefixSum % p);

            int targetMod = (currentMod - remainder + p) % p;

            if (modMap.containsKey(targetMod)) {
                int subarrayLength = i - modMap.get(targetMod);
                minLen = Math.min(minLen, subarrayLength);
            }
            modMap.put(currentMod, i);
        }
        return minLen == nums.length ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,4,2};
        log.info("Output : {}", minSubrray(arr, 6));
    }
}
