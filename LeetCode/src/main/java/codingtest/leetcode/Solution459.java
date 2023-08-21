package codingtest.leetcode;

public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int center = s.length() / 2;
        for(int i = 0 ; i < n ; i ++){
            if(s.substring(0, center-i).equals(s.substring(center+i, n))) {
                String centerS = s.substring(center-i, center+i);
                if(s.replaceAll(centerS,"").equals("")) {
                    return true;
                }
            }
        }

        return false;
    }
}
