package codingtest.leetcode;

import codingtest.TreeNode;

public class Solution988 {
    String result;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());

        return result;
    }

    public void dfs(TreeNode root, StringBuilder builder) {
        if(root == null) return;

        char c = (char) ('a' + root.val);
        builder.append(c);



        if(root.left == null && root.right == null) {
            String candidate = builder.reverse().toString();
            if(result == null) {
                result = candidate;
            } else {
                if(result.compareTo(candidate) > 0) {
                    result = candidate;
                } else {
                    return;
                }
            }
        }

        dfs(root.left, builder);
        dfs(root.right, builder);
        builder.deleteCharAt(builder.length());
    }
}
