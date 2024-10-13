package com.leetcode.solution.leetcodesolutions.HardQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 14/10/24, Monday
 **/

@Slf4j
public class SmallestRange {
    public static int[] smallestRange(List<List<Integer>> nums) {
        // PriorityQueue to track the minimum element across lists
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max_value = Integer.MIN_VALUE; // Track the maximum value across lists
        int start = 0, end = Integer.MAX_VALUE; // Result range

        // Initialize the heap by adding the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i).get(0);
            minHeap.offer(new int[]{num, i, 0}); // {value, list_index, index_in_list}
            max_value = Math.max(max_value, num); // Track the max value
        }

        // Process until the heap is empty or a list gets exhausted
        while (minHeap.size() == nums.size()) {
            int[] current = minHeap.poll(); // Get the minimum element
            int min_value = current[0]; // Current minimum element

            // If the current range is smaller, update the result range
            if (max_value - min_value < end - start) {
                start = min_value;
                end = max_value;
            }

            int list_index = current[1], index_in_list = current[2];

            // If there's a next element in the same list, push it into the heap
            if (index_in_list + 1 < nums.get(list_index).size()) {
                int next_value = nums.get(list_index).get(index_in_list + 1);
                minHeap.offer(new int[]{next_value, list_index, index_in_list + 1});
                max_value = Math.max(max_value, next_value); // Update the max value
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30)
        );

        log.info("Output : {}", smallestRange(nums));
    }
}
