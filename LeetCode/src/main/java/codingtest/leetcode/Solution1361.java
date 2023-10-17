package codingtest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, Node> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            if (leftChild[i] != -1 || rightChild[i] != -1) {
                Node parent = map.getOrDefault(i, new Node(i));
                if (leftChild[i] != -1) {
                    Node left = map.getOrDefault(leftChild[i], new Node(leftChild[i]));
                    if (left.parent != null) return false;
                    left.parent = parent;
                    parent.left = left;
                    map.put(left.val, left);
                }

                if (rightChild[i] != -1) {
                    Node right = map.getOrDefault(rightChild[i], new Node(rightChild[i]));
                    if (right.parent != null) return false;
                    right.parent = parent;
                    parent.right = right;
                    map.put(right.val, right);
                }
                map.put(parent.val, parent);
            }
        }

        boolean result = false;
        for (Map.Entry<Integer, Node> nodeEntry : map.entrySet()) {
            if(nodeEntry.getValue().parent == null) {
                if(result) {return false;}
                result = true;
            }
        }

        return result;
    }

    public class Node {
        Node parent;
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
