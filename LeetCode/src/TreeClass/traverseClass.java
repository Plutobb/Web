package TreeClass;

import java.util.LinkedList;
import java.util.List;

public class traverseClass {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        postorderTraversalHelper(root,list);
        return list;
    }
    public static void postorderTraversalHelper(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        postorderTraversalHelper(root.left,list);
        postorderTraversalHelper(root.right,list);
        list.add(root.val);
    }
}
