package codingtest.leetcode;

import codingtest.ListNode;

public class Solution2326 {
    int direction[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int dir = 0;
        int count = 0;

        int row = 0;
        int col = 0;
        int baser = 0;
        int basec = 0;

        int result[][] = new int[m][n];
        for(int r = 0 ; r < m ; r++) {
            for(int c = 0 ; c < n ; c++){
                result[r][c] = -1;
            }
        }

        while(head != null) {
            result[row][col] = head.val;
            head = head.next;
            row += direction[dir%4][0];
            col += direction[dir%4][1];


            if(row == m) {
                dir++;
                row--;
                col--;
                n--;
                continue;
            }
            if(col == n) {
                dir++;
                col--;
                row++;
                baser++;
                continue;
            }
            if(row < baser) {
                dir++;
                row++;
                col++;
                basec += 1;
                continue;
            }
            if(col < basec) {
                dir++;
                row--;
                col++;
                m--;
                continue;
            }
        }

        return result;
    }
}
