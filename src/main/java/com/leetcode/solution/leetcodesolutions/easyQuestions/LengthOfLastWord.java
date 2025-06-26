package com.leetcode.solution.leetcodesolutions.easyQuestions;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 26/06/25, Thursday
 **/

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        if (words.length == 0) {
            return 0;
        }
        return words[words.length - 1].length();
    }

    public static void main(String args[]) {
        int result = lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println("Length of the last word: " + result);
    }
}
