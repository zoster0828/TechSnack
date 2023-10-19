package codingtest.leetcode;

public class Solution2483 {
    public int bestClosingTime(String customers) {
        int maxValue = 0;
        int minValuePosition = 0;
        int currentValue = 0;
        for (int i = 0; i < customers.length(); i++) {
            if(isOpened(customers.charAt(i))) {
                currentValue++;
            } else {
                currentValue--;
            }

            if(currentValue > maxValue) {
                maxValue = currentValue;
                minValuePosition = i+1;
            }
        }

        return minValuePosition;
    }

    private boolean isOpened(char chars) {
        return chars == 'Y';
    }
}
