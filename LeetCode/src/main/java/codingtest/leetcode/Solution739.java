package codingtest.leetcode;

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Index indexes[] = new Index[len];

        Stack<Index> stack = new Stack();

        for(int i = len -1 ; i >= 0 ; i--) {
            if(stack.size() == 0) {
                Index index = new Index(temperatures[i], i);
                indexes[i] = index;
                stack.push(index);
            } else {

                Index top;
                do {
                    top = stack.pop();
                    if(top.num > temperatures[i]) {
                        indexes[i] = top;
                        stack.push(top);
                        stack.push(new Index(temperatures[i],i));
                        break;
                    }
                } while (!stack.isEmpty());

                if(indexes[i] == null) {
                    Index index = new Index(temperatures[i], i);
                    indexes[i] = index;
                    stack.push(index);
                }
            }
        }

        int result[] = new int[len];
        for(int i = 0 ; i < indexes.length ; i++) {
            result[i] = indexes[i].index - i;
        }

        return result;
    }


    private class Index {
        public int num;
        public int index;

        public Index(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
