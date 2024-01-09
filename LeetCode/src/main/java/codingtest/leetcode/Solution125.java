package codingtest.leetcode;

public class Solution125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length - 1;
        while(start <= end) {
            if(!Character.isAlphabetic(chars[start]) && !Character.isDigit(chars[start])) {
                start++;
                continue;
            }
            if(!Character.isAlphabetic(chars[end]) && !Character.isDigit(chars[end])) {
                end--;
                continue;
            }
            if(chars[start] == chars[end]) {
                start ++;
                end --;
            } else {
                return false;
            }
        }

        return true;
    }
}
