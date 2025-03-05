package com.leetcode.solution.leetcodesolutions.google;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 05/03/25, Wednesday
 **/

@Slf4j
public class DecompressString {
    public static String decompress(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                int num = 0;
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(num);
            } else if (ch == '[') {
                resultStack.push(current);
                current = new StringBuilder();
                index++;
            } else if (ch == ']') {
                StringBuilder temp = current;
                current = resultStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    current.append(temp);
                }
                index++;
            } else {
                current.append(ch);
                index++;
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        log.info(decompress("3[abc]4[ab]c")); // Output: abcabcabcababababc
        log.info(decompress("2[3[a]b]"));     // Output: aaabaaab
        log.info(decompress("10[a]"));        // Output: aaaaaaaaaa
        log.info(decompress("3[2[c]]"));     // Output: ccbccbccb
    }
}
