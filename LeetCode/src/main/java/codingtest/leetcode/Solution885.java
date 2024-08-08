package codingtest.leetcode;

public class Solution885 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int result[][] = new int[rows*cols][2];

        int count = 1;
        int direction = 0;
        int loop = 0;
        result[0][0] = rStart;
        result[0][1] = cStart;
        for(int i = 0 ; i < rows*cols ;) {
            direction++;
            int realDirection = direction % 4;
            for(int j = 0 ; j < count ; j++) {
                if(rStart >= 0 && rStart < rows) {
                    if(cStart >= 0 && cStart < cols) {
                        result[i][0] = rStart;
                        result[i][1] = cStart;
                        i++;
                    }
                }


                if(realDirection == 0) {
                    rStart--;
                }

                if(realDirection == 1) {
                    cStart++;
                }

                if(realDirection == 2) {
                    rStart++;
                }

                if(realDirection == 3) {
                    cStart--;
                }
            }
            loop ++;

            if(loop == 2) {
                loop = 0;
                count++;
            }
        }


        return result;
    }
}
