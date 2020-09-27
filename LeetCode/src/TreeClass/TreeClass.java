package TreeClass;

import java.util.*;

public class TreeClass {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
    static LinkedList<Integer> list = new LinkedList();
    static int maxCount = 0;
    static int count = 0;
    static int curNum;
    public static int[] findMode(TreeNode root) {

        findModeHelp(root);

        int[] ans = new int[list.size()];
        int  index = 0;
        for (int num : list) {
            ans[index++] = num;
        }
        return ans;
    }
    public static void findModeHelp(TreeNode root){
        if (root == null){
            return;
        }
        findModeHelp(root.left);
        if (root.val == curNum){
            count++;
        }else {
            curNum = root.val;
            count = 1;
        }
        if (count == maxCount){
            list.add(root.val);
        }else if (count > maxCount){
            maxCount = count;
            list.clear();
            list.add(root.val);
        }
        findModeHelp(root.right);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathSumAns = new LinkedList<>();
        List<Integer> pathSumPart = new LinkedList<>();
        findPathHelper(root,sum,pathSumPart,pathSumAns);
        return pathSumAns;
    }
    public static void findPathHelper(TreeNode root,int sum,List<Integer> pathSumPart,List<List<Integer>> pathSumAns){
        if (root == null){
            return;
        }
        pathSumPart.add(root.val);
        sum -= root.val;
        if (root.right == null && root.left == null && sum == 0) {
            pathSumAns.add(new LinkedList<>(pathSumPart));
        }
        findPathHelper(root.left,sum,pathSumPart,pathSumAns);
        findPathHelper(root.right,sum,pathSumPart,pathSumAns);
        pathSumPart.remove(pathSumPart.size()-1);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p){
            return root;
        }
        if (root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }else if (left != null){
            return left;
        }else {
            return right;
        }
    }
    public static TreeNode lowestCommonAncestorMethod2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < q.val && root.val <p.val){
            return lowestCommonAncestorMethod2(root.right,p,q);
        }else if (root.val > q.val && root.val > p.val){
            return lowestCommonAncestorMethod2(root.left,p,q);
        }else {
            return root;
        }
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(6);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(0);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(3);
        TreeNode g = new TreeNode(5);
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;
        c.left = h;
        c.right = i;
        System.out.println(lowestCommonAncestorMethod2(a,a,h));
    }
}
