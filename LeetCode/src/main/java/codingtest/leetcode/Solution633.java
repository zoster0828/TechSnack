package codingtest.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution633 {
    public boolean judgeSquareSum(int c) {
        Set<Integer> set2 = new HashSet();

        int left = 0, right = (int) Math.sqrt(c) + 1;

        do {
            int square = left*left;
            int square2 = right*right;
            set2.add(square);
            set2.add(square2);

            if(set2.contains(c - (square)) ||set2.contains(c-(square2))) {
                return true;
            }
            left++;
            right--;
        } while(left <= right);

        return false;
    }
}
