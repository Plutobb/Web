import java.util.LinkedList;

public class OuLian3 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(5);
        stack.push(9);
        stack.push(0);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.max());
        System.out.println(stack.pop());
        System.out.println(stack.max());
    }

    public static class Stack{
        LinkedList<Integer> list = new LinkedList<>();
        int MAX = -1;
        public void push (int n){
            list.add(n);
            if (n > MAX){
                MAX = n;
            }
        }

        public int pop(){
            int last = (int) list.getLast();
            list.removeLast();
            return last;
        }

        public int max(){
            return MAX;
        }
    }
}
