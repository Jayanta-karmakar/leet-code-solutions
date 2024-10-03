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
        // Calculate the total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is already divisible by p, no sub array needs to be removed
        int remainder = (int) (totalSum % p);
        if (remainder == 0) {
            return 0;
        }

        // HashMap to store the prefix sum mod p and the last index where it occurs
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);  // Initialize with 0 mod at index -1 to handle full sub array cases

        long prefixSum = 0;
        int minLen = nums.length;

        // Iterate through the array to find the smallest sub array to remove
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currentMod = (int) (prefixSum % p);

            // Find the mod we need to remove to make the remaining sum divisible by p
            int targetMod = (currentMod - remainder + p) % p;

            // Check if we have seen this mod before
            if (modMap.containsKey(targetMod)) {
                // Calculate the subarray length
                int subarrayLength = i - modMap.get(targetMod);
                minLen = Math.min(minLen, subarrayLength);
            }

            // Update the map with the current prefix mod
            modMap.put(currentMod, i);
        }

        // If no valid subarray was found, return -1
        return minLen == nums.length ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,4,2};
        log.info("Output : {}", minSubrray(arr, 6));
    }
}
