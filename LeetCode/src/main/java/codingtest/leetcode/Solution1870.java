package codingtest.leetcode;

public class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if(n-1 > hour) {
            return -1;
        }

        double speed = 1;
        while(true) {
            if(speed == 10000000) {
                System.out.println();
            }
            double h = hour;
            for(int i = 0 ; i < n-1 ; i++) {
                double take = dist[i] / speed;
                take = Math.ceil(take);
                h -= take;
            }

            h -= (double) (dist[n-1] / speed);

            if(h >= 0) {
                return (int)speed;
            }

            speed++;
        }
    }
}
