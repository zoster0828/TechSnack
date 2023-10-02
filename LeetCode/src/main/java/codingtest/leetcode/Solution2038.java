package codingtest.leetcode;

public class Solution2038 {
    public boolean winnerOfGame(String colors) {
        char[] chars = colors.toCharArray();
        int length = chars.length;

        int aliceScore = 0;

        int continuous = 0;
        char prevCharacter = 'C';
        for(int i = 0 ; i <= length ; i ++) {
            if(isNotEndOfLine(length, i) && isContinue(prevCharacter, chars[i])) {
                continuous++;
                continue;
            }

            if(isAliceScore(prevCharacter)) {
                aliceScore += scoreCalculation(continuous);
            } else if(isBobScore(prevCharacter)) {
                aliceScore -= scoreCalculation(continuous);
            }

            if(isNotEndOfLine(length, i)) {
                prevCharacter = chars[i];
            }
            continuous = 1;

        }

        return aliceScore > 0;
    }

    private static boolean isContinue(char prevCharacter, char chars) {
        return prevCharacter == chars;
    }

    private boolean isBobScore(char prevCharacter) {
        return prevCharacter == 'B';
    }

    private boolean isAliceScore(char prevCharacter) {
        return prevCharacter == 'A';
    }

    private boolean isNotEndOfLine(int length, int i) {
        return i != length;
    }

    private int scoreCalculation(int continuous) {
        if(continuous < 3) {
            return 0;
        } else {
            return continuous - 2;
        }
    }
}
