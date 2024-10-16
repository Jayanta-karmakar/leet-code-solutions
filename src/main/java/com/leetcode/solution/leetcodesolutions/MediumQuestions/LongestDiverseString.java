package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 17/10/24, Thursday
 **/

@Slf4j
public class LongestDiverseString {
    public static String longestDiverseString(int a, int b, int c) {
        // Create a max-heap to always get the most frequent character
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        // Add available characters to the heap
        if (a > 0) pq.add(new int[] { 'a', a });
        if (b > 0) pq.add(new int[] { 'b', b });
        if (c > 0) pq.add(new int[] { 'c', c });

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            // Pick the most frequent character
            int[] first = pq.poll();

            // Check if we can add the character (i.e., no triple repetition)
            int n = result.length();
            if (n >= 2 && result.charAt(n - 1) == first[0] && result.charAt(n - 2) == first[0]) {
                // If adding this character would result in "aaa", "bbb", or "ccc", try the next one
                if (pq.isEmpty()) break;  // No other characters to add

                int[] second = pq.poll();
                result.append((char) second[0]);
                if (--second[1] > 0) pq.add(second);  // Add back to the heap if still available

                // Put the first character back for future use
                pq.add(first);
            } else {
                // Safe to add the most frequent character
                result.append((char) first[0]);
                if (--first[1] > 0) pq.add(first);  // Add back to the heap if still available
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        log.info("Output : {}", longestDiverseString(1, 1, 7));
    }
}
