package codingtest.leetcode;

import codingtest.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution863Test {
    @Test
    void test1() {
        Solution863 solution = new Solution863();
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2, treeNode7, treeNode4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5, treeNode6, treeNode2);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(1, treeNode0, treeNode8);
        TreeNode treeNode3 = new TreeNode(3, treeNode5, treeNode1);
        List<Integer> actual = solution.distanceK(treeNode3, treeNode5, 2);
        for (Integer integer : actual) {
            System.out.print(integer + ", ");
        }
    }

    @Test
    void test2() {
        Solution863 solution = new Solution863();
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1, treeNode3, treeNode2);
        TreeNode treeNode0 = new TreeNode(0, treeNode1, null);
        List<Integer> actual = solution.distanceK(treeNode0, treeNode2, 1);
        for (Integer integer : actual) {
            System.out.print(integer + ", ");
        }
    }

    @Test
    void test3() {
        Solution863 solution = new Solution863();
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1, treeNode3, null);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode0 = new TreeNode(0, treeNode2, treeNode1);
        List<Integer> actual = solution.distanceK(treeNode0, treeNode3, 3);
        for (Integer integer : actual) {
            System.out.print(integer + ", ");
        }
    }
}