package codingtest;

import codingtest.ListNode;

import java.util.*;

public class Solution {

    public int solution(int N) {
        String candidate = String.valueOf(N);
        int length = candidate.length();
        StringBuilder builder = new StringBuilder();

        int start = N < 0 ? length - 1 : 0;
        int end = N < 0 ? -1 : length;
        int step = N < 0 ? -1 : 1;

        boolean notFound = true;
        for (int i = start; notFound && i != end; i += step) {
            if (candidate.charAt(i) == '5' && notFound) {
                notFound = false;
            } else {
                builder.append(candidate.charAt(i));
            }
        }

        if (N < 0) {
            builder.reverse();
        }

        return Integer.valueOf(builder.toString());
    }
}