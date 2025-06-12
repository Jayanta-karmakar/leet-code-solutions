package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JAYANTA KARMAKAR
 * @date 12-06-2025
 **/

public class LongestWordDictionary {

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<>();
        String result = "";

        for (String word : words) {
            if (word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                built.add(word);
                if (word.length() > result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestWordDictionary longestWordDictionary = new LongestWordDictionary();
        String[] words = {"w", "wo", "wor", "world", "word"};
        String result = longestWordDictionary.longestWord(words);
        System.out.println("Longest word in the dictionary: " + result); // Output: world
    }
}
