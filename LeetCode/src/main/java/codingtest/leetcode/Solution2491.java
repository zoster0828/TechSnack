package codingtest.leetcode;

public class Solution2491 {
    public long dividePlayers(int[] skill) {
        int n = skill.length;

        int[] p = new int[1001];
        int sum = 0;
        for(int i : skill) {
            p[i]++;
            sum += i;
        }

        if(sum % (n/2) != 0) return -1;

        int avg = sum / ((n) / 2);

        long result = 0;
        for(int i = 1 ; i < 1001 ; i++) {
            if(p[i] != 0) {
                if (p[i] == p[avg - i]) {
                    result += (long)(i * (avg - i)) * ((i==(avg-i)) ? (p[i]/2) : p[i]);
                    p[i] = 0;
                    p[avg - i] = 0;
                } else {
                    return -1;
                }
            }
        }

        return result;
    }
}
