package codingtest.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mors = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> result = new HashSet();
        for(String word : words) {
            String temp = "";
            for(char c : word.toCharArray()) {
                temp += mors[c-'a'];
            }
            result.add(temp);
        }

        return result.size();
    }
}
