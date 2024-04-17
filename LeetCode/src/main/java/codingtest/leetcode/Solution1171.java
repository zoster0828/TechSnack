package codingtest.leetcode;

import codingtest.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> reversemap = new HashMap();
        Map<Integer, ListNode> beforeMap = new HashMap();

        ListNode before = null;
        ListNode node = head;
        while(node != null) {
            reversemap.put(node.val, node);
            beforeMap.put(node.val, before);

            int reverseKey = node.val * -1;

            if(reversemap.containsKey(reverseKey)) {
                ListNode reverseNode = reversemap.get(reverseKey);

                {
                    ListNode reverseBefore = beforeMap.get(reverseNode.val);
                    reverseBefore.next = reverseNode.next;
                    reversemap.remove(reverseNode.val);
                    beforeMap.remove(reverseNode.val);
                }

                before.next = node.next;
            }

            before = node;
            node = node.next;
        }

        return head;
    }
}
