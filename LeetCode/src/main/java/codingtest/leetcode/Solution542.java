package codingtest.leetcode;

public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int column = mat.length;
        int row = mat[0].length;

        for(int y = 0 ; y < column ; y++) {
            for(int x = 0 ; x < row ; x++) {
                if(mat[y][x] == 0) {
                    spray0(mat, x, y);
                }
            }
        }

        return mat;
    }

    private void spray0(int[][] mat, int x, int y) {
        if(x-1 >= 0) {
            mat[y][x-1] = 1;
            spray1minus(mat, x-1, y, 1);
        }
        if(y-1 >= 0) {
            mat[y-1][x] = 1;
            spray1minus(mat, x, y-1, 1);
        }
        if(x+1 < mat[0].length) {
            mat[y][x+1] = 1;
            spray1plus(mat, x+1, y, 1);
        }
        if(y+1 < mat.length) {
            mat[y+1][x] = 1;
            spray1plus(mat, x, y+1, 1);
        }
    }

    private void spray1plus(int[][] mat, int x, int y, int value) {
        if(x+1 < mat[0].length && mat[y][x+1] != 0) {
            if(mat[y][x + 1] == 1 || mat[y][x + 1] > value +1) {
                mat[y][x + 1] = value + 1;
                spray1plus(mat, x + 1, y, value + 1);
            }
        }
        if(y+1 < mat.length && mat[y+1][x] != 0) {
            if(mat[y+1][x] == 1 || mat[y+1][x] > value +1) {
                mat[y+1][x] = value+1;
                spray1plus(mat, x, y+1, value+1);
            }
        }
    }

    private void spray1minus(int[][] mat, int x, int y, int value) {
        if(x-1 >= 0 && mat[y][x-1] != 0) {
            if(mat[y][x - 1] == 1 || mat[y][x - 1] > value +1) {
                mat[y][x - 1] = value + 1;
                spray1minus(mat, x - 1, y, value + 1);
            }
        }
        if(y-1 >= 0 && mat[y-1][x] != 0) {
            if(mat[y - 1][x] == 1 || mat[y - 1][x] > value +1) {
                mat[y - 1][x] = value + 1;
                spray1minus(mat, x, y - 1, value + 1);
            }
        }
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
