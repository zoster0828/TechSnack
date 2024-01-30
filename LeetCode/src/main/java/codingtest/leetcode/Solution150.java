package codingtest.leetcode;

import java.util.Stack;

public class Solution150 {
    Stack<String> stack = new Stack();
    public int evalRPN(String[] tokens) {
        int result = 0;
        for(String str : tokens) {
            if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*")) {
                String a = stack.pop();
                String b = stack.pop();
                int pre = Integer.parseInt(a);
                int nex = Integer.parseInt(b);
                int temp = calc(pre,nex,str);
                stack.push("" + temp);
            } else {
                stack.push(str);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private int calc(int a, int b, String not) {
        System.out.println(String.format("a : %d, b : %d, not : %s", a,b,not));
        switch(not) {
            case "+":
                return b+a;
            case "-":
                return b-a;
            case "*":
                return b*a;
            case "/":
                return b/a;
            default:
                throw new RuntimeException("");
        }
    }
}
