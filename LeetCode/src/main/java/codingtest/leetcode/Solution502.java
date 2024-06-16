package codingtest.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ProfitAndCapital[] profitAndCapitals = new ProfitAndCapital[profits.length];
        for(int i = 0 ; i < profits.length ; i++) {
            profitAndCapitals[i] = new ProfitAndCapital(profits[i], capital[i]);
        }

        Arrays.sort(profitAndCapitals, Comparator.comparingInt(x -> x.profit));

        for(int i = 0 ; i < k ; i++) {
            int po =  profitAndCapitals.length - 1;
            while(po > -1 && profitAndCapitals[po].capital > w) {
                po--;
            }

            if(po == -1) continue;

            w += profitAndCapitals[po].profit;
            profitAndCapitals[po].capital = Integer.MAX_VALUE;
        }

        return w;
    }

    class ProfitAndCapital {
        public int profit;
        public int capital;
        public ProfitAndCapital(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
