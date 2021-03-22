package TreeClass;

public class judgeIsBalanceTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right))<=1 && isBalanced(root.left)&&isBalanced(root.right);
    }

    private int  height(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
