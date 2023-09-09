package codingtest;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode generator(int... args) {
        ListNode head = null;
        ListNode result = null;
        for (int arg : args) {
            if(result == null) {
                head = new ListNode(arg);
                result = head;
                continue;
            }

            ListNode curr = new ListNode(arg);
            head.next = curr;
            head = head.next;
        }

        return result;
    }
}
