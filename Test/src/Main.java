import java.util.HashSet;
import java.util.Set;

public class Main {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void stringChoice(String str){
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder("");
        for (Character c : str.toCharArray()){
            if (!set.contains(c)){
                set.add(c);
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (list1!= null && list2!= null){
            if (list1.val <= list2.val){
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        while (list1 != null){
            cur.next = new ListNode(list1.val);
            list1 = list1.next;
            cur = cur.next;
        }
        while (list2 != null){
            cur.next = new ListNode(list2.val);
            list2 = list2.next;
            cur = cur.next;
        }
        return newHead.next;
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String string = sc.nextLine();
//            stringChoice(string);
//        }
        ListNode a = new  ListNode(1);
        ListNode b = new  ListNode(2);
        ListNode c = new  ListNode(3);
        ListNode d = new  ListNode(4);
        ListNode e = new  ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode i = new  ListNode(1);
        ListNode o = new  ListNode(3);
        ListNode m = new  ListNode(6);
        i.next = o;
        o.next = m;

        Merge(a,null);

    }
}
