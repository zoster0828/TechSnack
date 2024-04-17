package codingtest.leetcode;

import codingtest.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution404Test {
    @Test
    void test1() {
        Solution404 solution404 = new Solution404();
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);


        solution404.sumOfLeftLeaves(treeNode1);
    }
}