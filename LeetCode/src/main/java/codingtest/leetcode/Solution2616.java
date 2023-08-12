package codingtest.leetcode;

import java.util.*;


public class Solution2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int n = nums.length;
        List<Index> indexes = new ArrayList();
        for(int i = 0 ; i < n-1 ; i++) {
            for(int j = i+1 ; j < n ; j++) {
                int a = Math.abs(nums[i] - nums[j]);
                indexes.add(new Index(i, j, a));
            }
        }
        Collections.sort(indexes, Comparator.comparingInt(a -> a.diff));

        int count = 0;
        int max = 0;
        int[] used = new int[n];
        for(int i = 0 ; i < indexes.size() ; i++) {
            if(count == p) break;
            Index index = indexes.get(i);
            if(used[index.x] == 0 && used[index.y] == 0) {
                max = Math.max(index.diff, max);
                used[index.x] = 1;
                used[index.y] = 1;
                count++;
            }
        }

        return max;
    }

    class Index{
        int x;
        int y;
        int diff;
        public Index(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }
}
