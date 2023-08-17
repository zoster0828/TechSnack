package codingtest.leetcode;

public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int column = mat.length;
        int row = mat[0].length;
        int result[][] = new int[column][row];
        for(int y = 0 ; y < column ; y++) {
            for(int x = 0 ; x < row ; x++) {
                int value = getNear(result, mat, x, y);
                result[y][x] = value;
            }
        }

        return result;
    }

    public int getNear(int result[][], int[][] mat, int x, int y) {
        if(mat[y][x] == 0) {
            return 0;
        }

        int value = Integer.MAX_VALUE;
        if(x-1 >= 0) {
            value = Math.min(result[y][x-1]+1, value);
        }

        if(y-1 >= 0) {
            value = Math.min(result[y-1][x]+1, value);
        }

        if(x+1 < mat[0].length) {
            value = Math.min(result[y][x+1]+1, value);
        }
        if(y+1 < mat.length) {
            value = Math.min(result[y+1][x]+1, value);
        }

        return value;
    }
}
