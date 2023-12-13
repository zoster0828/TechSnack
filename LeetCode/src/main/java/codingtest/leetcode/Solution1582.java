package codingtest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1582 {
    public int numSpecial(int[][] mat) {
        List<Integer> row = new ArrayList();
        List<Integer> col = new ArrayList();
        for (int i = 0; i < mat.length; i++) {
            boolean exists = false;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (exists) {
                        exists = false;
                        break;
                    } else {
                        exists = true;
                    }
                }
            }
            if (exists) {
                row.add(i);
            }
        }

        for (int i = 0; i < mat[0].length; i++) {
            boolean exists = false;
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][i] == 1) {
                    if (exists) {
                        exists = false;
                        break;
                    } else {
                        exists = true;
                    }
                }
            }
            if (exists) {
                col.add(i);
            }
        }

        int result = 0;
        for (int i = 0; i < row.size(); i++) {
            for (int j = 0; j < col.size(); j++) {
                if (mat[row.get(i)][col.get(j)] == 1) {
                    result++;
                }
            }
        }

        return result;
    }
}
