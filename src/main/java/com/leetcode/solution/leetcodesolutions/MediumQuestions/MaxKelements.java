package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 14/10/24, Monday
 **/

@Slf4j
public class MaxKelements {
    public static long maxKelements(int[] nums, int k) {
        // Max heap to store numbers (use negative values to simulate a max heap)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all elements from nums into the heap
        for (int num : nums) {
            maxHeap.offer(num);
        }

        long score = 0;

        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Extract the largest element
            int largest = maxHeap.poll();

            // Add the largest element to the score
            score += largest;

            // Replace the element with ceil(largest / 3) and add back to the heap
            int reduced = (int) Math.ceil(largest / 3.0);
            maxHeap.offer(reduced);
        }

        return score;
    }

    public static void main(String[] args) {
        int[] nums = {10, 10, 10, 10, 10};
        int k = 5;
        log.info("Output : {}", maxKelements(nums, k));
    }
}
