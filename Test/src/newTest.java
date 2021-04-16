import java.util.LinkedList;
import java.util.Stack;

public class newTest {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Byte[] arr = new Byte[1024*25];

    public static void main(String[] args) throws InterruptedException {
        LinkedList<newTest> ms = new LinkedList<>();
        while (true){
            ms.add(new newTest());
            Thread.sleep(10);
        }
    }

    public static void prvFind(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        prvFind(root.left);
        prvFind(root.right);
    }

    public static void prvFind2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if (root != null){
            stack.add(root);
        }
        while (stack.size() > 0 ){
            TreeNode popNode = stack.pop();
            if (popNode.right != null){
                stack.add(popNode.right);
            }
            if (popNode.left != null){
                stack.add(popNode.left);
            }
            System.out.println(popNode.val);
        }

        while (stack.size() > 0 ){
            TreeNode popNode = stack.pop();
            
        }
    }
}
