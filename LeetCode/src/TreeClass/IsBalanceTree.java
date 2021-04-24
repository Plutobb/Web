package TreeClass;

public class IsBalanceTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(height(root.right),height(root.left))+1;
    }
}
