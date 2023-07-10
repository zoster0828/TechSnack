package codingtest.leetcode;

public class Solution2272 {

    public int largestVariance(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 1;
        int max = 0;
        while(left < chars.length -1 && right < chars.length) {
            int value = countVariance(s.substring(left, right));
            if(value > max) {
                max = value;
                right++;
            } else if(value == max) {
                left++;
            } else {
                if(left == right) {right++;}
                else
                    left++;
            }
        }

        return max;
    }
    public int largestVariance3(String s) {
        Alphabet[] alphabets = new Alphabet[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(alphabets[chars[i]-'a'] == null) {
                alphabets[chars[i]-'a'] = new Alphabet(chars[i],i);
            }else {
                alphabets[chars[i]-'a'].update(i);
            }
        }

        Alphabet max = null;
        Alphabet min = null;
        for(Alphabet alphabet : alphabets) {
            if(alphabet == null) continue;
            if(max == null) {
                max = alphabet;
                min = alphabet;
                continue;
            }

            if(max.size() < alphabet.size()) {
                max = alphabet;
            }
            if(min.size() > alphabet.size()) {
                min = alphabet;
            }
        }

        int start = 0;
        int end = 0;
        int result = 0;
        start = max.getStart();
        end = max.getEnd();
        if(start < end) {
            String substring = s.substring(start, end);
            result = Math.max(result, countVariance(substring));
        }

        start = max.getStart();
        end = min.getEnd();
        if(start < end) {
            String substring = s.substring(start, end);
            result = Math.max(result, countVariance(substring));
        }

        start = min.getStart();
        end = min.getEnd();
        if(start < end) {
            String substring = s.substring(start, end);
            result = Math.max(result, countVariance(substring));
        }

        start = min.getStart();
        end = max.getEnd();
        if(start < end) {
            String substring = s.substring(start, end);
            result = Math.max(result, countVariance(substring));
        }

        return result == 0 ? 0 : result + 1;
    }

    class Alphabet {
        char c;
        int start;
        int end;
        int count;
        public Alphabet(char c, int start) {
            this.c = c;
            this.start = start;
            this.end = start;
            this.count = 1;
        }
        public void update(int position) {
            this.end = position;
            this.count++;
        }
        public int size() {
            return this.count;
        }
        public int getStart() {return this.start;}
        public int getEnd() {return this.end;}
    }

    public int findAll(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                result = Math.max(result, countVariance(substring));
            }
        }

        return result;
    }

    public int countVariance(String s) {
        int[] alphabet = new int[26];
        for(char c : s.toCharArray()) {
            alphabet[c-'a']++;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int num : alphabet) {
            if(num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return max - min;
    }
}
