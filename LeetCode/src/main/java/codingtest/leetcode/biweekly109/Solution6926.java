package codingtest.leetcode.biweekly109;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution6926 {
        public String sortVowels(String s) {
            char[] chars = s.toCharArray();
            List<Integer> vowels = new ArrayList<>();
            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                boolean vowel = isVowel(chars[i]);
                if(vowel) {
                    vowels.add(chars[i]-'A');
                    positions.add(i);
                }
            }

            Collections.sort(vowels);

            for (int i = 0; i < positions.size(); i++) {
                chars[positions.get(i)] = (char) (vowels.get(i).intValue() + 'A');
            }

            return new String(chars);
        }

        private boolean isVowel(char aChar) {
            if(Character.toString(aChar).matches("[aeiouAEIOU]")) {
                return true;
            }

            return false;
        }
}
