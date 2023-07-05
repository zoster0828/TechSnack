package codingtest.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] po = new int[26][3];
        for(int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            if(po[c-'a'][0] == 0) {
                po[c-'a'][0] = -1;
                po[c-'a'][1] = i;
            } else {
                po[c-'a'][0] = -2;
                po[c-'a'][2] = i;
            }

        }

        int result = -1;
        for(int i = 0 ; i < 26 ; i ++) {
            if(po[i][0] == -2) {
                int temp = po[i][2] - po[i][1] -1;
                if(temp > result) result = temp;
            }
        }
        return result;
    }
}
