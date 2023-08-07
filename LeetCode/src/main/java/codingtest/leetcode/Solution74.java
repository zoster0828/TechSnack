package codingtest.leetcode;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int right = getLength(row, column);
        int value  = getValue(matrix, right);
        if(value < target) return false;
        if(value == target) return true;
        return binarySearch(matrix, 0, right, target);
    }

    private boolean binarySearch(int[][] matrix, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int value = getValue(matrix, mid);
            if(value == target) return true;

            if(target > value) {
                return binarySearch(matrix, mid+1, right, target);
            } else {
                return binarySearch(matrix, left, mid-1, target);
            }
        }

        return false;
    }

    private int getValue(int[][] matrix, int position) {
        int x = position / matrix[0].length;
        if(x == matrix.length) {
            x = x-1;
            int y = matrix[0].length-1;
            return matrix[x][y];
        }
        int y = position % matrix[0].length;

        return matrix[x][y];
    }

    private int getLength(int row, int column) {
        return column * (row);
    }
}
