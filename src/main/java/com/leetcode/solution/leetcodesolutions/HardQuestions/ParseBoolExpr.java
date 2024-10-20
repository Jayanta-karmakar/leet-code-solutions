package com.leetcode.solution.leetcodesolutions.HardQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 21/10/24, Monday
 **/

@Slf4j
public class ParseBoolExpr {
    public static boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',') {
                continue; // Ignore commas
            } else if (ch != ')') {
                stack.push(ch); // Push everything except closing parentheses
            } else {
                // Pop and evaluate the subexpression inside parentheses
                List<Character> subExpr = new ArrayList<>();

                while (stack.peek() != '(') {
                    subExpr.add(stack.pop());
                }

                stack.pop(); // Remove the '('
                char operator = stack.pop(); // Get the operator !, &, or |

                // Evaluate based on the operator
                boolean result = evaluateSubExpr(subExpr, operator);

                // Push the result back as 't' for true and 'f' for false
                stack.push(result ? 't' : 'f');
            }
        }

        // The final result is the only character left in the stack
        return stack.pop() == 't';
    }

    private static boolean evaluateSubExpr(List<Character> subExpr, char operator) {
        if (operator == '!') {
            // NOT operator: negates the only value in the subexpression
            return subExpr.get(0) == 'f';
        } else if (operator == '&') {
            // AND operator: return true only if all values are true
            for (char ch : subExpr) {
                if (ch == 'f') return false;
            }
            return true;
        } else if (operator == '|') {
            // OR operator: return true if any value is true
            for (char ch : subExpr) {
                if (ch == 't') return true;
            }
            return false;
        }
        return false; // Should not reach here
    }

    public static void main(String[] args) {
        String str = "&(|(f))";
        log.info("Output : {}", parseBoolExpr(str));
    }
}
