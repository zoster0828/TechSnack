package codingtest.leetcode.biweekly113;

import java.util.List;

public class Solution3 {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int result = 0;
        for (int i = 0; i < coordinates.size(); i++) {
            for (int j = i+1; j < coordinates.size(); j++) {
                if(i==j) continue;
                if(XOR(coordinates.get(i), coordinates.get(j),k)) {
                    result++;
                }
            }
        }

        return result;
    }

    public boolean XOR(List<Integer> a, List<Integer> b, int k) {
        int num = (a.get(0) ^ b.get(0));
        if(num > k) {
            return false;
        }
        int num2 = (a.get(1) ^ b.get(1));

        if(num + num2 == k) {
            return true;
        }else return false;
    }
}
