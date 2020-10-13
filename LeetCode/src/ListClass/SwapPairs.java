package ListClass;

public class SwapPairs {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode front = newHead;
        ListNode cur = head;
        ListNode after = head.next;
        while (cur.next != null){
            //交换节点;
            front.next = after;
            cur.next = after.next;
            after.next = cur;
            //交换后指针顺序为 front after cur 因此需要重新调整指针的位置;
            front = cur;
            cur = cur.next;
            if (cur == null){
                return newHead.next;
            }
            after = cur.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode head = swapPairs(l4);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
