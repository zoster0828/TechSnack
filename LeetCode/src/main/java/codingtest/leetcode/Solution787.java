package codingtest.leetcode;

import java.util.*;

public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> priceMap = new HashMap<>();
        for (int[] flight : flights) {
            priceMap.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;

        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{src, 0});

        int stopOver = 0;
        while(!queue.isEmpty() && stopOver <= k) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] poll = queue.poll();
                int source = poll[0];
                int prevDistance = poll[1];

                List<int[]> list = priceMap.get(source);

                if(list == null) {
                    continue;
                }

                for(int[] destPrice : list) {
                    int dest = destPrice[0];
                    int distance = prevDistance + destPrice[1];

                    if(stopOver == k && dest != dst) {
                      continue;
                    }

                    if(dp[dest] >= distance) {
                        dp[dest] = distance;
                        queue.add(new int[]{dest, dp[dest]});
                    }
                }
            }
            stopOver++;
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
}
