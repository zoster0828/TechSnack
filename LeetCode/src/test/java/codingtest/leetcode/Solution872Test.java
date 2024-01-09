package codingtest.leetcode;

import codingtest.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution872Test {
    @Test
    void test1() {
        Solution872 solution872 = new Solution872();
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2, treeNode7, treeNode4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5, treeNode6, treeNode2);
        TreeNode treeNode0 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(1, treeNode0, treeNode8);
        TreeNode treeNode3 = new TreeNode(3, treeNode5, treeNode1);

        TreeNode treeNode14 = new TreeNode(4);
        TreeNode treeNode19 = new TreeNode(9);
        TreeNode treeNode18 = new TreeNode(8);
        TreeNode treeNode12 = new TreeNode(2, treeNode19, treeNode18);
        TreeNode treeNode16 = new TreeNode(6);
        TreeNode treeNode17 = new TreeNode(7);
        TreeNode treeNode15 = new TreeNode(5, treeNode16, treeNode17);
        TreeNode treeNode11 = new TreeNode(1, treeNode14, treeNode12);
        TreeNode treeNode13 = new TreeNode(3, treeNode15, treeNode11);
        assertTrue(solution872.leafSimilar(treeNode3, treeNode13));
    }
}