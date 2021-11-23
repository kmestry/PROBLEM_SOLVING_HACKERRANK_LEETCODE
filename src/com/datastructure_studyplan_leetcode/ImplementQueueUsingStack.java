package com.datastructure_studyplan_leetcode;

import java.util.Stack;


class ImplementQueueUsingStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public ImplementQueueUsingStack() {

    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1.push(x);
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack2.push(x);

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {

        return stack1.peek();

    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}


