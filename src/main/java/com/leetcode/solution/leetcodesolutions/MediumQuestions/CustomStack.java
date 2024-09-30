package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 30/09/24, Monday
 **/

//  CustomStack stk = new CustomStack(3); // Stack is []
//  stk.push(1);                          // Stack becomes [1]
//  stk.push(2);                          // Stack becomes [1, 2]
//  System.out.println(stk.pop());        // Returns 2, stack becomes [1]
//  stk.push(2);                          // Stack becomes [1, 2]
//  stk.push(3);                          // Stack becomes [1, 2, 3]
//  stk.push(4);                          // Stack still [1, 2, 3] because maxSize is 3
//  stk.increment(5, 100);                // Stack becomes [101, 102, 103]
//  stk.increment(2, 100);                // Stack becomes [201, 202, 103]
//  System.out.println(stk.pop());        // Returns 103, stack becomes [201, 202]
//  System.out.println(stk.pop());        // Returns 202, stack becomes [201]
//  System.out.println(stk.pop());        // Returns 201, stack becomes []
//  System.out.println(stk.pop());        // Returns -1 because stack is empty

@Slf4j
public class CustomStack {
    private int[] stack;
    private int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        this.top = 0;
    }

    public void push(int x) {
        if (top < stack.length) {
            stack[top++] = x;
            log.info("PUSH : {}", x);
        }
    }

    public int pop() {
        if (top == 0) {
            return -1;
        }
        log.info("POP : {}", stack[top]);
        return stack[--top];
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, top);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}
