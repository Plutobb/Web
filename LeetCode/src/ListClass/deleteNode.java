package ListClass;

public class deleteNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode begin = newHead;
        ListNode mid = pHead;
        ListNode end = pHead.next;
        while (end != null){
            if (mid.val != end.val) {
                mid = mid.next;
                begin = begin.next;
            } else {
                while (end != null && mid.val == end.val) {
                    end = end.next;
                }
                mid = end;
                begin.next = end;
            }
            if (end != null) {
                end = end.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d1 = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode e1 = new ListNode(4);
  //      a.next = a1;
//        a1.next = b;
//        b.next = c;
//        c.next = d1;
//        d1.next = d;
//        d.next = e;
//        e.next = e1;
        deleteDuplication(null);
    }
}
