package codingtest.leetcode;

import codingtest.TreeNode;

public class Solution2265 {
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        Value value = sumOfNodes(root, 1);
        if(value.isThat(root.val)) {
            result++;
        }

        return result;
    }

    boolean hasChild(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    Value sumOfNodes(TreeNode node, int count) {
        if(hasChild(node)) {
            int countTot = 0;
            int sum = 0;
            if(node.left != null) {
                Value left = sumOfNodes(node.left, count + 1);
                countTot += left.count;
                sum += left.sum;
            }
            if(node.right != null) {
                Value right = sumOfNodes(node.right, count + 1);
                countTot += right.count;
                sum += right.sum;
            }
            Value value = new Value(countTot, sum);
            if(value.isThat(node.val)) {
                result++;
            }
            return value;
        } else {
            Value value = new Value(node.val, count);
            if(value.isThat(node.val)) {
                result++;
            }
            return value;
        }
    }

    public class Value {
        public int count;
        public int sum;
        public Value(int count, int sum) {
            this.count = count;
            this.sum = sum;
        }

        public boolean isThat(int v) {
            if(v == 0) return count == 0 || sum == 0;
            else {
                if(count == 0 || sum == 0) return false;
                return (sum / count) == v;
            }
        }
    }
}
