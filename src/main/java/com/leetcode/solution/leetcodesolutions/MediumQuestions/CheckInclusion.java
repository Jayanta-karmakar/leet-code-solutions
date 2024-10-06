package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 05/10/24, Saturday
 **/

@Slf4j
public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26]; // frequency array for s1
        int[] s2Freq = new int[26]; // frequency array for the window in s2

        // Fill the frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        // Sliding window on s2
        for (int i = 0; i < s2.length(); i++) {
            // Add current character to s2Freq
            s2Freq[s2.charAt(i) - 'a']++;

            // Remove the character that's left behind the window (when window size exceeds s1's length)
            if (i >= s1.length()) {
                s2Freq[s2.charAt(i - s1.length()) - 'a']--;
            }

            // Check if the current window matches the frequency of s1
            if (matches(s1Freq, s2Freq)) {
                return true;
            }
        }

        return false;
    }

    private static boolean matches(int[] s1Freq, int[] s2Freq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        log.info("Output : {}", checkInclusion(s1, s2));
    }
}
