package codingtest.leetcode;

public class Solution1531 {
    public int getLengthOfOptimalCompression(String s, int k) {
        String result = s;
        int size = 1;
        while(k > 0) {
            char[] chars = result.toCharArray();

            char prev = '1';
            int count = 0;

            for(int i = 0 ; i < chars.length ; i++) {
                if(prev !=  chars[i]) {
                    if(count <= size) {
                        k-=count;
                    } else {
                        result += prev + count;
                    }
                    prev = chars[i];
                    count = 1;
                }
            }
        }

        return result.length();
    }
}
