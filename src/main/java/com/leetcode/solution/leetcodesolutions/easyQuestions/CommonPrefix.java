package com.leetcode.solution.leetcodesolutions.easyQuestions;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 **/

public class CommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] sample = new String[3];
        sample[0] = "abc";
        sample[1] = "cab";
        sample[2] = "abc";
        long start = System.currentTimeMillis();
        System.out.println("output : " + longestCommonPrefix(sample));
        long end = System.currentTimeMillis();
        System.out.println("time taken in ms : " + (end - start));
    }
}
