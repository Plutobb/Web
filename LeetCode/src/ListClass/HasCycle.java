package ListClass;

public class HasCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
      }
  }
    //判断链表中是否有环;
    public static boolean hasCycle(ListNode head) {
        //采用快慢指针的方法;
        //如果存在环,快指针会追上慢指针;
        ListNode fast = head;
        ListNode slow = head;
        if (head == null){
            return false;
        }
        while (fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node.next = node2;
        node2.next = node3;
        node3.next = node3;
        System.out.println(hasCycle(node));
    }
}
