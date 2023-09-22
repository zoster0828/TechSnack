package codingtest.leetcode.weekly363;

import java.util.List;

public class Solution2861 {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
//        List<Integer> machine = selectMachine(composition, cost);
        int result = Integer.MIN_VALUE;
        for (List<Integer> machine : composition) {
            int value = 0;
            int count = 0;
            Integer[] stocks = stock.toArray(Integer[]::new);
            while(value <= budget) {
                value += generate(machine, stocks, cost);

                count++;
            }

            result = Math.max(result, count-1);
        }

        return result;
    }

    private int generate(List<Integer> machine, Integer[] stocks, List<Integer> cost) {
        int value = 0;
        for (int i = 0; i < machine.size(); i++) {
            int req = machine.get(i);
            if(stocks[i] > req) {
                stocks[i] -= req;
                req = 0;
            } else {
                req -= stocks[i];
                stocks[i] = 0;
            }
             value += req * cost.get(i);
        }
        return value;
    }

    private List<Integer> selectMachine(List<List<Integer>> composition, List<Integer> cost) {
        int min = Integer.MAX_VALUE;
        List<Integer> result = null;
        for (List<Integer> integers : composition) {
            int sum = 0 ;
            for (int i = 0; i < integers.size(); i++) {
                sum+=integers.get(i) * cost.get(i);
            }
            if(sum < min) {
                result = integers;
                min = sum;
            }
        }

        return result;
    }
}
