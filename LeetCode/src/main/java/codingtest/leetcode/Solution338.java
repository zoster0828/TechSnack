package codingtest.leetcode;

public class Solution338 {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for(int i = 0 ; i <= n ; i ++) {
            String bit = getBitString(i);
            int value = 0;
            for (char c : bit.toCharArray()) {
                if(c=='1') {
                    value++;
                }
            }
            result[i] = value;
        }

        return result;
    }

    private String getBitString(int i) {
        return Integer.toBinaryString(i);
    }
}
