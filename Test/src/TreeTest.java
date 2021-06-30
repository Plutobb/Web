import java.util.LinkedList;

public class TreeTest {
    static  int mySum = 0;
    static LinkedList<Integer> path = new LinkedList<>();
    static LinkedList<LinkedList<Integer>> ans = new LinkedList<>();
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        d.right = e;
        findPath(a,10);
        System.out.println(ans);
    }
    public static void findPath(TreeNode root,int sum){
        mySum += root.val;
        path.add(root.val);

        if (mySum == sum && root.left == null && root.right == null){
            ans.add(new LinkedList<>(path));
            return;
        }
        if (root.left != null){
            findPath(root.left,sum);
        }
        if (root.right != null){
            findPath(root.right,sum);
        }
        mySum -= root.val;
        path.removeLast();
    }
}
