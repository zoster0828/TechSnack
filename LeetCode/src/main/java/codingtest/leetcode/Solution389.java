package codingtest.leetcode;

import java.util.Arrays;

public class Solution389 {
    public char findTheDifference(String s, String t) {
        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();

        int suma = 0;
        for(int i = 0 ; i < a1.length ; i ++) {
            suma += a1[i];
        }

        int sumb = 0;
        for(int i = 0 ; i < a2.length ; i ++) {
            sumb += a2[i];
        }

        return (char) (sumb-suma);
    }
}
