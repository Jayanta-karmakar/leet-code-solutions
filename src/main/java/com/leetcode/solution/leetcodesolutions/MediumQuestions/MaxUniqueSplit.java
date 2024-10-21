package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 21/10/24, Monday
 **/

@Slf4j
public class MaxUniqueSplit {
    public static int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private static int backtrack(String s, int start, Set<String> uniqueSubstrings) {
        if (start == s.length()) {
            return uniqueSubstrings.size();
        }

        int maxUnique = 0;

        // Try splitting the string at every possible point
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);

            // If the substring is unique, try to add it and explore further
            if (!uniqueSubstrings.contains(substring)) {
                uniqueSubstrings.add(substring);
                maxUnique = Math.max(maxUnique, backtrack(s, end, uniqueSubstrings));
                // Backtrack: remove the substring after exploring that path
                uniqueSubstrings.remove(substring);
            }
        }

        return maxUnique;
    }

    public static void main(String[] args) {
        String str = "ababccc";
        log.info("Output : {}", maxUniqueSplit(str));
    }
}


//    Example 1:
//    Input: s = "ababccc"
//    Output: 5
//    Explanation:
//    One way to split maximally is ['a', 'b', 'ab', 'c', 'cc'].
//    Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.


//    Example 2:
//    Input: s = "aba"
//    Output: 2
//    Explanation: One way to split maximally is ['a', 'ba'].