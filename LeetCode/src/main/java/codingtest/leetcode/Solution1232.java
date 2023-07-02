package codingtest.leetcode;

public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        float inclination = getInclination(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        for(int i = 2 ; i < coordinates.length ; i++) {
            float temp = getInclination(coordinates[0][0], coordinates[0][1], coordinates[i][0], coordinates[i][1]);
            if(temp != inclination) return false;
        }

        return true;
    }

    float getInclination(int x, int y, int x1, int y1) {
        int row = x - x1;
        int high = y - y1;

        float result = (float) high / row;
        return result < 0 ? -result : result;
    }
}
