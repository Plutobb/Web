package ListClass;

public class ListClass {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinWei = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        while (p1 != null || p2 != null){
            int x = (p1 != null)? p1.val : 0;
            int y = (p2 != null)? p2.val : 0;
            int sum = (x + y + jinWei) % 10;
            jinWei = (x + y + jinWei) / 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (p1!= null) {
                p1 = p1.next;
            }
            if (p2!= null){
                p2 = p2.next;
            }
        }
        if (jinWei > 0){
            cur.next = new ListNode(1);
        }
        return head.next;
    }

}
