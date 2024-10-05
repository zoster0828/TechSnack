package codingtest.leetcode;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;

        int[] exists = new int[26];

        for(char c : s1.toCharArray()) {
            exists[c-'a']++;
        }

        int left = 0;
        int right = n;
        int[] diff = new int[26];
        for(int i = left ; i < right ; i++) {
            diff[s2.charAt(i) - 'a']++;
        }

        while(right <= m) {
            boolean result = same(exists, diff);
            if(result) {
                return true;
            }

            if(right==m) return false;

            diff[s2.charAt(left++) - 'a']--;
            diff[s2.charAt(right++) - 'a']++;
        }

        return false;
    }

    public boolean same(int[] arr1, int[] arr2) {
        for(int i = 0 ; i < 26 ; i ++){
            if(arr1[i] == arr2[i]) continue;
            else return false;
        }
        return true;
    }
}
