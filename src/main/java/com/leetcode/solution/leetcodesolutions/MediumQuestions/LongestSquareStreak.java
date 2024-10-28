package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;


/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 28/10/24, Monday
 **/

@Slf4j
public class LongestSquareStreak {
    private static final int N = 100001; // The range limit for bitset equivalent

    public static int longestSquareStreak(int[] nums) {
        // Create a boolean array to act as the bitset to check if a number exists
        boolean[] hasX = new boolean[N];
        for (int x : nums) {
            if (x < N) { // Ensure we don't go out of bounds
                hasX[x] = true;
            }
        }

        int maxStreak = 0;

        // Iterate through the numbers to find the longest streak
        for (int x = 2; x < N; x++) {
            if (!hasX[x]) continue;

            int streak = 1;
            long z = (long) x * x; // Square of the current number, use long to prevent overflow

            // Continue squaring as long as the result is within bounds and exists in the array
            while (z < N && hasX[(int) z]) {
                streak++;
                hasX[(int) z] = false; // Mark as visited
                z = z * z;
            }

            maxStreak = Math.max(maxStreak, streak);

            // Early exit if we find the maximum streak of 5 (optional, depending on the problem constraints)
            if (maxStreak == 5) break;
        }

        return maxStreak < 2 ? -1 : maxStreak;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,6,16,8,2};
        log.info("Output : {}", longestSquareStreak(nums));

    }
}
