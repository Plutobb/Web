package ListClass;

import java.util.HashMap;

public class ReorderList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        HashMap<Integer,ListNode> map = new HashMap<>();
        int begin = 0;
        int end = 0;
        ListNode node = head;
        while (node != null){
            map.put(end++,node);
            node = node.next;
        }
        end--;
        while (begin < end){
            map.get(begin++).next = map.get(end);
            map.get(end--).next = map.get(begin);
            if (begin >= end){
                map.get(begin).next = null;
                break;
            }
        }
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
        //d.next = e;
        reorderList(a);
        System.out.println(1);
    }
}
