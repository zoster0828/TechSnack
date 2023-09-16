package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution332Test {

    @Test
    void test() {
        List<List<String>> list = Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"));
        Solution332 solution332 = new Solution332();
        List<String> itinerary = solution332.findItinerary(list);
        for (String s : itinerary) {
            System.out.print(s+", ");
        }
    }
}