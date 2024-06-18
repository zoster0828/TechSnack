package codingtest.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        DifficultyProfit[] difficultyProfits = new DifficultyProfit[difficulty.length];

        for(int i = 0 ; i < difficultyProfits.length ; i++) {
            difficultyProfits[i] = new DifficultyProfit(difficulty[i], profit[i]);
        }

        Arrays.sort(difficultyProfits, Comparator.comparingInt(x -> x.difficulty));

        int prev = 0;
        for(int i = 0 ; i < difficultyProfits.length ; i++) {
            if(difficultyProfits[i].profit < prev) {
                difficultyProfits[i].profit = prev;
            }

            prev = difficultyProfits[i].profit;
        }

        int result = 0;
        for(int i = 0 ; i < worker.length ; i++) {
            int po = 0;
            while(po < difficultyProfits.length && worker[i] >= difficultyProfits[po].difficulty) {
                if (po + 1 < difficultyProfits.length && worker[i] < difficultyProfits[po + 1].difficulty) {
                    break;
                }
                po++;
            }
            if (po == difficultyProfits.length || worker[i] < difficultyProfits[po].difficulty) {
                po--;
            }
            if(po >= 0)
                result += difficultyProfits[po].profit;
        }

        return result;
    }

    class DifficultyProfit{
        public int difficulty;
        public int profit;
        public DifficultyProfit(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}
