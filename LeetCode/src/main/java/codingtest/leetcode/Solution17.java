package codingtest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        char[] digit = digits.toCharArray();
        int[] count = new int[digit.length];
        List<String> result = new ArrayList();
        int n = 3;
        for(int press = 0 ; press < digit.length ; press++){
            while(count[press] < n){

                String temp = "";
                for(int i = 0 ; i < digit.length ; i++) {
                    temp += print(count[i], digit[i]);
                    if(i == press)
                    {
                        count[i]++;
                    }
                }

                result.add(temp);

            }
            count[press] = 0;
        }
        return result;
    }

    public char print(int count, char num) {
        if(num == '2') {
            if(count == 0) return 'a';
            if(count == 1) return 'b';
            if(count== 2) return 'c';
        }

        if(num == '3') {
            if(count == 0) return 'd';
            if(count == 1) return 'e';
            if(count== 2) return 'f';
        }

        if(num == '4') {
            if(count == 0) return 'g';
            if(count == 1) return 'h';
            if(count== 2) return 'i';
        }

        if(num == '5') {
            if(count == 0) return 'j';
            if(count == 1) return 'k';
            if(count== 2) return 'l';
        }

        if(num == '6') {
            if(count == 0) return 'm';
            if(count == 1) return 'n';
            if(count== 2) return 'o';
        }

        if(num == '7') {
            if(count == 0) return 'p';
            if(count == 1) return 'q';
            if(count == 2) return 'r';
            if(count == 3) return 's';
        }

        if(num == '8') {
            if(count == 0) return 't';
            if(count == 1) return 'u';
            if(count== 2) return 'v';
        }

        if(num == '9') {
            if(count == 0) return 'w';
            if(count == 1) return 'x';
            if(count== 2) return 'y';
            if(count== 3) return 'z';
        }

        return '0';
    }
}
