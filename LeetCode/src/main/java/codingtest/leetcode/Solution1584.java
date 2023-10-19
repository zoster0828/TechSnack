package codingtest.leetcode;

import java.util.Arrays;

public class Solution1584 {
    public int minCostConnectPoints(int[][] points) {
        if(points.length == 1) return 0;

        int[][] done = new int[points.length][points.length];

        for(int i = 0 ; i < points.length ; i++) {
            int min = Integer.MAX_VALUE;
            int from = 0;
            int to = 0;
            for (int j = 0; j < points.length; j++) {
                if(i==j) {continue;}
                int distance = getDistance(points[i], points[j]);
                if(min > distance) {
                    min = distance;
                    from = i;
                    to = j;
                }
            }
            if(done[from][to] == 0 || done[from][to] != min) {
                done[from][to] = min;
                done[to][from] = min;
            }
        }

        int result = 0;
        for (int[] ints : done) {
            for (int anInt : ints) {
                result += anInt;
            }
        }
        return result/2;
    }

    private int getDistance(int[] point, int[] point1) {
        return Math.abs(point[0] - point1[0]) + Math.abs(point[1] - point1[1]);
    }
}
