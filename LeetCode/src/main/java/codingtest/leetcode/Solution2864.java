package codingtest.leetcode;

public class Solution2864 {
    public String maximumOddBinaryNumber(String s) {
        boolean hasOne = false;
        char[] array = new char[s.length()];
        for(int i = 0, k = 0, j = s.length()-2 ; i < s.length(); i++){
            if(s.charAt(i) == '1') {
                if(hasOne) {
                    array[k] = '1';
                    k++;
                }
                else{
                    hasOne = true;
                    array[s.length()-1] = '1';
                }
            } else {
                array[j] = '0';
                j--;
            }
        }

        return new String(array);
    }
}
