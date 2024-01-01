package codingtest.leetcode;

public class Solution1897 {
    public boolean makeEqual(String[] words) {
        int length = words.length;
        int[] counts = new int[26];
        int count = 0;
        for(String str : words) {
            for(char c : str.toCharArray()) {
                counts[c-'a']++;
                count = Math.max(counts[c-'a'], count);
            }
        }

        for(int c : counts) {
            if(c % length != 0) {
                return false;
            }
        }

        return true;
    }
}