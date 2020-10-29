package TreeClass;

public class SumNumbers {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public  int sumNumbers(TreeNode root) {
        return dpsRoot(root,0);
    }

    private int dpsRoot(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }else {
            return dpsRoot(root.left, sum) + dpsRoot(root.right, sum);
        }
    }

}
