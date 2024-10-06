package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 06/10/24, Sunday
 **/

@Slf4j
public class AreSentencesSimilar {

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split the sentences into words
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int i = 0, j = 0;
        int n1 = words1.length;
        int n2 = words2.length;

        // Compare words from the beginning
        while (i < n1 && i < n2 && words1[i].equals(words2[i])) {
            i++;
        }

        // Compare words from the end
        while (j < n1 - i && j < n2 - i && words1[n1 - 1 - j].equals(words2[n2 - 1 - j])) {
            j++;
        }

        // Check if the combined length of matching words is enough
        return i + j >= Math.min(n1, n2);
    }

    public static void main(String[] args) {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        log.info("Output : {}", areSentencesSimilar(sentence1, sentence2));
    }
}
