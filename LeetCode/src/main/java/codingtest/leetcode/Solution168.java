package codingtest.leetcode;

public class Solution168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int nam = columnNumber % 26;
        columnNumber -= nam;
        while(columnNumber != 1 && columnNumber != 0){
            columnNumber = columnNumber / 26;
            if(columnNumber == 1)
                stringBuilder.append('A');
            else
                stringBuilder.append('Z');
        }
        stringBuilder.append((char)('A' + nam -1));

        return stringBuilder.toString();
    }
}
