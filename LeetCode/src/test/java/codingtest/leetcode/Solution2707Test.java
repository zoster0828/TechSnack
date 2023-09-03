package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2707Test {
    @Test
    void test1() {
        Solution2707 solution2707 = new Solution2707();
        assertEquals(15, solution2707.minExtraChar("azvzulhlwxwobowijiyebeaskecvtjqwkmaqnvnaomaqnvf  ", new String[]{"na","i","edd","wobow","kecv","b","n","or","jj","zul","vk","yeb","qnfac","azv","grtjba","yswmjn","xowio","u","xi","pcmatm","maqnv"}));
        assertEquals(7, solution2707.minExtraChar("dwmodizxvvbosxxw  ", new String[]{"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"}));
        assertEquals(1, solution2707.minExtraChar("leetscode", new String[]{"leet","code","leetcode"}));
        assertEquals(3, solution2707.minExtraChar("sayhelloworld", new String[]{"hello","world"}));
    }
}