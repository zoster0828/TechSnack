package codingtest.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String splitted[] = sentence.split("\\s+");
        for (String str : dictionary) {
            for (int i = 0; i < splitted.length; i++) {

                if (splitted[i].startsWith(str)) {
                    splitted[i] = str;
                }
            }
        }

        return String.join(" ", splitted);
    }

}
