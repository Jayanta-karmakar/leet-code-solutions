package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 04/03/25, Tuesday
 **/

@Slf4j
public class MaximumNumberOfEvents {

    public static int maxEvents(int[][] events) {
        // Sort events by start day
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Stores end days
        int maxEventsAttended = 0;
        int eventIndex = 0;
        int totalDays = 0;

        // Find the last day among all events
        for (int[] event : events) {
            totalDays = Math.max(totalDays, event[1]);
        }

        // Process each day from 1 to the last event's end day
        for (int day = 1; day <= totalDays; day++) {
            // Add all events that start today to the heap
            while (eventIndex < events.length && events[eventIndex][0] == day) {
                minHeap.offer(events[eventIndex][1]); // Add end day
                eventIndex++;
            }

            // Remove expired events (those with end day < current day)
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends the earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll(); // Attend this event
                maxEventsAttended++;
            }
        }

        return maxEventsAttended;
    }

    public static void main(String[] args) {
        int[][] events = {{2, 3}, {1, 2}, {3, 4}};
        log.info("Maximum number of events attended: {}", maxEvents(events));
    }
}
