package codingtest.leetcode.weekly355;

import java.util.ArrayList;
import java.util.List;

public class Solution6921 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList();
        for(String str : words) {
            char[] charArray = str.toCharArray();
            String temp = "";
            for (char c : charArray) {
                if(c != separator) {
                    temp += c;
                }
                if(c == separator) {
                    if(!temp.isBlank())
                        result.add(temp);
                    temp = "";
                }
            }
            if(!temp.isBlank())
                result.add(temp);
        }

        return result;
    }
}
