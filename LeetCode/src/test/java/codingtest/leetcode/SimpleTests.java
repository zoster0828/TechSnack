package codingtest.leetcode;

import org.junit.jupiter.api.Test;

public class SimpleTests {
    @Test
    void test1() {
        int length = 11;
        int k = 3;
        int split = length / k;
        int nam = length % k;
        for(int i = 0 ; i < k ; i++) {
                System.out.println(String.format("%d,%d",split*i,split*(i+1)+(nam-- > 0 ? 1 : 0)));
        }
    }
}
