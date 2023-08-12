package codingtest.leetcode;

public class Solution63 {
    int x;
    int y;
    int result;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        result = 0;
        x = obstacleGrid[0].length;
        y = obstacleGrid.length;

        search(new int[y][x],obstacleGrid, 0, 0);
        return result;
    }

    public void search(int[][] path,int[][] obstacleGrid, int startX, int startY) {
        if(startX >= x || startY >= y || startX < 0 || startY < 0) {
            return;
        }

        if(obstacleGrid[startY][startX] == 1) return;

        if(path[startY][startX] == 1) return;

        if(startX == x-1 && startY == y-1) {
            result += 1;
            return;
        }

        path[startY][startX] = 1;
        search(copy(path), obstacleGrid,startX+1, startY);
        search(copy(path), obstacleGrid, startX, startY+1);
//        search(copy(path), obstacleGrid, startX-1, startY);
//        search(copy(path), obstacleGrid, startX, startY-1);
    }

    public int[][] copy(int[][] src) {
        if (src == null) {
            return null;
        }

        int[][] copy = new int[src.length][];
        for (int i = 0; i < src.length; i++) {
            copy[i] = src[i].clone();
        }

        return copy;
    }
}
