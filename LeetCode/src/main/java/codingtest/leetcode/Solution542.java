package codingtest.leetcode;

public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int column = mat.length;
        int row = mat[0].length;
        for(int y = 0 ; y < column ; y++) {
            for(int x = 0 ; x < row ; x++) {
                if(mat[y][x] != 0 && getNear0(mat, x, y)) {
                    continue;
                }

                mat[y][x] = getNear(mat, x, y);
            }
        }

        return mat;
    }
    public int getNear(int[][] mat, int x, int y) {
        if(mat[y][x] == 0) {
            return 0;
        }

        int value = Integer.MAX_VALUE;
        if(x-1 >= 0) {
            value = Math.min(mat[y][x-1]+1, value);
        }

        if(y-1 >= 0) {
            value = Math.min(mat[y-1][x]+1, value);
        }

        return value;
    }
    public boolean getNear0(int[][] mat, int x, int y) {
        if(x-1 >= 0) {
            if(mat[y][x-1] == 0) return true;
        }

        if(y-1 >= 0) {
            if(mat[y-1][x] == 0) return true;
        }

        if(x+1 < mat[0].length) {
            if(mat[y][x+1] == 0) return true;
        }
        if(y+1 < mat.length) {
            if(mat[y+1][x] == 0) return true;
        }

        return false;
    }
}
