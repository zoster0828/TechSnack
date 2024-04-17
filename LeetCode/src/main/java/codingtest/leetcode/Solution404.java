package codingtest.leetcode;

import codingtest.TreeNode;

public class Solution404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return sum;
        if(root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sumOfLeftLeaves(root.left);
            }
        }

        sumOfLeftLeaves(root.right);

        return sum;
    }
}
