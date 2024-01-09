package codingtest;

import codingtest.ListNode;

import java.io.Serializable;
import java.util.*;

class Solution {
    public boolean isPathCrossing(String path) {
        char[] chars = path.toCharArray();

        for(int i = 0 ; i < chars.length -1 ; i++) {
            if(two(i, chars)) {
                return true;
            }
            if(four(i, chars)) {
                return true;
            }
        }

        return false;
    }

    private boolean four(int num, char[] chars) {
        boolean N = false;
        boolean E = false;
        boolean S = false;
        boolean W = false;

        for(int i = num ; i < 4 ; i ++) {
            if(chars[i] == 'N') N = true;
            if(chars[i] == 'E') E = true;
            if(chars[i] == 'S') S = true;
            if(chars[i] == 'W') W = true;
        }

        if(N && E && S && W) {
            return true;
        }
        return false;
    }

    private boolean two(int i, char[] chars) {
        if(chars[i] == 'N') {
            if(chars[i+1] == 'S') {
                return true;
            }

            return false;
        }

        if(chars[i] == 'S') {
            if(chars[i+1] == 'N') {
                return true;
            }

            return false;
        }

        if(chars[i] == 'E') {
            if(chars[i+1] == 'W') {
                return true;
            }

            return false;
        }

        if(chars[i] == 'W') {
            if(chars[i+1] == 'E') {
                return true;
            }

            return false;
        }

        return false;
    }

}