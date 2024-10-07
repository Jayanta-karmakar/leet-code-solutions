package com.leetcode.solution.leetcodesolutions.easyQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 07/10/24, Monday
 **/

@Slf4j
public class MinLength {
    public static int minLength(String s) {
        // Create a stack to help in the removal of substrings
        Stack<Character> stack = new Stack<>();

        // Traverse through each character in the string
        for (char c : s.toCharArray()) {
            // If the stack has at least one character, check for "AB" or "CD"
            if (!stack.isEmpty()) {
                char top = stack.peek();

                // Check for "AB" or "CD" and remove them if found
                if ((top == 'A' && c == 'B') || (top == 'C' && c == 'D')) {
                    stack.pop(); // Remove the pair by popping the top character
                } else {
                    stack.push(c); // Otherwise, push the current character
                }
            } else {
                stack.push(c); // Push the first character to the stack
            }
        }

        // The remaining stack size will be the minimum possible length
        return stack.size();
    }

    public static void main(String[] args) {
        String string = "ABFCACDB";
        log.info("Output : {}", minLength(string));
    }
}
