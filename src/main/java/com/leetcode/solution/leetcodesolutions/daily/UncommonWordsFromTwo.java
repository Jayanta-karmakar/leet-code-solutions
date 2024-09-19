package com.leetcode.solution.leetcodesolutions.daily;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 17/09/24, Tuesday
 **/

@Slf4j
public class UncommonWordsFromTwo {
    public static String[] uncommonFromSentences(String s1, String s2) {
        // Split the sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        // Use a HashMap to store the word counts
        Map<String, Integer> wordCount = new HashMap<>();

        // Count the words from both sentences
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Find words that occur exactly once
        List<String> uncommonWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }

        // Convert the list to an array and return
        return uncommonWords.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        String[] result = uncommonFromSentences(s1, s2);
        log.info("Output : {}", (Object) result);
    }
}
