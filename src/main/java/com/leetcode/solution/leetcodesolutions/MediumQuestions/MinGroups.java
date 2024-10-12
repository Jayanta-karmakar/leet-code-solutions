package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 12/10/24, Saturday
 **/

@Slf4j
public class MinGroups {
    public static int minGroups(int[][] intervals) {
        // Create a list to store the events
        List<int[]> events = new ArrayList<>();

        // For each interval [l, r], add a +1 event at l and a -1 event at r + 1
        for (int[] interval : intervals) {
            events.add(new int[] { interval[0], 1 });    // Start of an interval
            events.add(new int[] { interval[1] + 1, -1 }); // End of an interval
        }

        // Sort the events. If two events have the same time, process end (-1) events before start (+1) events
        events.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int maxGroups = 0, currentGroups = 0;

        // Sweep through the events
        for (int[] event : events) {
            currentGroups += event[1];  // Add 1 if it's a start, subtract 1 if it's an end
            maxGroups = Math.max(maxGroups, currentGroups);  // Track the maximum number of overlapping intervals
        }

        return maxGroups;
    }

    public static void main(String[] args) {
        int[][] intervals = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        log.info("Output : {}", minGroups(intervals));
    }
}
