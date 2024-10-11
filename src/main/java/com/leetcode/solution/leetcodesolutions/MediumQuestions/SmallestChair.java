package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 11/10/24, Friday
 **/

@Slf4j
public class SmallestChair {
    public static int smallestChair1st(int[][] times, int targetFriend) {
        int n = times.length;

        // List to store arrival and leaving events
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            events.add(new int[]{times[i][0], i, 1}); // Arrival event
            events.add(new int[]{times[i][1], i, 0}); // Leaving event
        }

        // Sort events by time, and prioritize leaving (0) over arrival (1) when the time is the same
        events.sort((a, b) -> a[0] == b[0] ? a[2] - b[2] : a[0] - b[0]);

        // Min-heap to store the smallest available chairs
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        // Initialize heap with chairs 0 to n-1 (since there are n friends)
        for (int i = 0; i < n; i++) {
            availableChairs.offer(i);
        }

        // Array to store which chair each friend is sitting on
        int[] friendToChair = new int[n];

        for (int[] event : events) {
            int time = event[0];
            int friend = event[1];
            int type = event[2];

            if (type == 1) { // Arrival event
                int chair = availableChairs.poll(); // Get the smallest available chair
                friendToChair[friend] = chair;

                // If this is the target friend, return the chair they sit on
                if (friend == targetFriend) {
                    return chair;
                }
            } else { // Leaving event
                int chair = friendToChair[friend]; // Get the chair of the leaving friend
                availableChairs.offer(chair); // Make this chair available
            }
        }

        return -1; // Should not reach here
    }

    public static void main(String[] args) {
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        int targetFriend = 1;
        log.info("Output : {}", smallestChair1st(times, targetFriend));
    }

    public int smallestChair2nd(int[][] times, int targetFriend) {
        int n = times.length;

        // List to store arrival and leaving events
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            events.add(new int[]{times[i][0], i, 1}); // Arrival event
            events.add(new int[]{times[i][1], i, 0}); // Leaving event
        }

        // Sort events by time, and prioritize leaving (0) over arrival (1) when the time is the same
        events.sort((a, b) -> a[0] == b[0] ? a[2] - b[2] : a[0] - b[0]);

        // Array to mark occupied chairs
        boolean[] occupiedChairs = new boolean[n];

        // Array to store which chair each friend is sitting on
        int[] friendToChair = new int[n];

        for (int[] event : events) {
            int time = event[0];
            int friend = event[1];
            int type = event[2];

            if (type == 1) { // Arrival event
                int chair = -1;
                // Find the smallest available chair
                for (int i = 0; i < n; i++) {
                    if (!occupiedChairs[i]) {
                        chair = i;
                        occupiedChairs[i] = true; // Mark chair as occupied
                        break;
                    }
                }
                friendToChair[friend] = chair;

                // If this is the target friend, return the chair they sit on
                if (friend == targetFriend) {
                    return chair;
                }
            } else { // Leaving event
                int chair = friendToChair[friend]; // Get the chair of the leaving friend
                occupiedChairs[chair] = false; // Mark chair as available
            }
        }

        return -1; // Should not reach here
    }
}
