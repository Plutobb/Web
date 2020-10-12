package TreeClass;

public class GetMinimumDifference {
    private int postNum = -1;
    private int ans = Integer.MAX_VALUE;
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public int getMinimumDifference(TreeNode root) {
        bianLiTree(root);
        return ans;
    }
    public void bianLiTree(TreeNode root) {
        if (root == null) {
            return;
        }
        bianLiTree(root.left);
        if (postNum != -1) {
            ans = Math.min(Math.abs(root.val - postNum), ans);
        }
        postNum = root.val;
        bianLiTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(3);
        c.left = a;
        c.right = b;
    }
}
