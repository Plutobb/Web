public class YueWenJiTuan1 {


     public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
     }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = deleteDuplicationNode(a);
        System.out.println(1);
    }
    //删除重复节点
    public static ListNode deleteDuplicationNode (ListNode head) {
        ListNode newHead = new ListNode(-1);//傀儡节点
        newHead.next = head;

        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                ListNode tmp = cur.next;
                while (tmp != null&&tmp.val == cur.val){
                    tmp = tmp.next;
                }
                pre.next = tmp;
                cur = pre.next;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return newHead.next;
    }
}
