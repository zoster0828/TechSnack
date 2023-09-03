package codingtest.leetcode;

import java.util.*;

public class Solution2707 {
    public int minExtraChar(String s, String[] dictionary) {
        Arrays.sort(dictionary, Comparator.comparing(f -> f.length()));
        for (int i = dictionary.length - 1; i >= 0 ; i--) {
            s = s.replaceAll(dictionary[i],"");
        }

        return s.length();
    }
}
