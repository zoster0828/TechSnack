package codingtest.leetcode;

import codingtest.TreeNode;

import java.util.*;

public class Solution863 {
    List<Integer> result = new ArrayList();
    Set<TreeNode> visit = new HashSet();
    Map<Integer, TreeNode> parentMap = new HashMap();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        makeParentsMap(null, root, target);
        findChilds(target, k);
        findParents(target, k-1);
        return result;
    }

    private void findParents(TreeNode node, int k) {
        TreeNode parent = parentMap.get(node.val);
        if(parent == null) return;
        if(k == 0) {
            result.add(parent.val);
        }else {
            findParents(parent, k - 1);
            if (node != parent.left)
                findChilds(parent.left, k - 1);
            if (node != parent.right)
                findChilds(parent.right, k - 1);
        }
    }

    void findChilds(TreeNode node, int k) {
        if(node == null) return;
        if(visit.contains(node)) return;

        visit.add(node);

        if(k==0) {
            result.add(node.val);
        } else {
            findChilds(node.left, k-1);
            findChilds(node.right, k-1);
        }
    }

    void makeParentsMap(TreeNode parent, TreeNode node, TreeNode target) {
        if(node == null) {
            return;
        }

        if(parent != null) {
            parentMap.put(node.val, parent);
        }

        if(node.val == target.val) {
            return;
        }

        makeParentsMap(node, node.left, target);
        makeParentsMap(node, node.right, target);
    }
}
