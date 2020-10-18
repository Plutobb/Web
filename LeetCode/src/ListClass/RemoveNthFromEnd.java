package ListClass;

public class RemoveNthFromEnd {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    //
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0){
            return head;
        }
        ListNode begin = head;
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            if (begin != null) {
                begin = begin.next;
            }else {
                return head;
            }
        }
        if (begin == null){
            return head.next;
        }else {
            begin = begin.next;
        }
        while (begin != null){
            begin = begin.next;
            end = end.next;
        }
        end.next = end.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode ans = removeNthFromEnd(a,6);
        System.out.println(1);
    }
}
