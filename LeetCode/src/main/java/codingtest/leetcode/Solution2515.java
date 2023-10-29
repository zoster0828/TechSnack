package codingtest.leetcode;

public class Solution2515 {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;

        for(int i = 0 ; i < n ; i++) {
            int right = startIndex + i;
            int left = startIndex - i > -1 ? startIndex -i : n+(startIndex-i);
            if(words[right].equals(target) || words[left].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
