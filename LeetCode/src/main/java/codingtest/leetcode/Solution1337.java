package codingtest.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Soldier> priorityQueue = new PriorityQueue<>();

        for(int row = 0 ; row < mat.length ; row++) {
            int count = countSoldiers(mat[row]);
            priorityQueue.add(new Soldier(count, row));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().rowNumber;
        }
        return result;
    }

    public int countSoldiers(int[] row) {
        int count = 0 ;
        for(int i = 0 ; i < row.length ; i ++) {
            if(row[i] == 1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    private class Soldier implements Comparable<Soldier> {
        int count;
        int rowNumber;

        public Soldier(int count, int rowNumber) {
            this.count = count;
            this.rowNumber = rowNumber;
        }
        @Override
        public int compareTo(Soldier soldier) {
            if(soldier.count == this.count) {
                return soldier.rowNumber > this.rowNumber ? -1 : 1;
            }

            return soldier.count > this.count ? -1 : 1;
        }
    }
}
