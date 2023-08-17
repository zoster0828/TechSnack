package codingtest.leetcode;

public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int column = mat.length;
        int row = mat[0].length;
        int result[][] = new int[column][row];
        for(int i = 0 ; i < column  ; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = mat[i][j];
            }
        }

        for(int y = 0 ; y < column ; y++) {
            for(int x = 0 ; x < row ; x++) {
                if(mat[y][x] == 0) {
                    spray(result, mat, x, y);
                }
            }
        }

        return result;
    }

    private void spray(int[][] result, int[][] mat,  int x, int y) {
        for(int i = x-1, num=1 ; i >= 0 ; i--,num++) {
            if(result[y][i] != 0 && result[y][i] < num) {
                break;
            }
            if(mat[y][i] != 0) {
                result[y][i] = num;
            }
        }

        for(int i = x+1, num=1 ; i < result[0].length ; i++,num++) {
            if(result[y][i] != 0 && result[y][i] < num) {
                break;
            }

            if(mat[y][i] != 0)
                result[y][i] = num;
        }

        for(int i = y-1, num=1 ; i >= 0 ; i--,num++) {
            if(result[i][x] != 0 && result[i][x] < num) {
                break;
            }
            if(mat[i][x] != 0)
                result[i][x] = num;
        }

        for(int i = y+1, num=1 ; i < result.length ; i++,num++) {
            if(result[i][x] != 0 && result[i][x] < num) {
                break;
            }
            if(mat[i][x] != 0)
                result[i][x] = num;
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
