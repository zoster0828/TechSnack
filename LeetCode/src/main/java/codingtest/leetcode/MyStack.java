package codingtest.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Deque<Integer> queue;
    public MyStack() {
        queue = new LinkedList();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        return queue.pollLast();
    }

    public int top() {
        return queue.getLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}