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
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(11);
        TreeNode d = new TreeNode(2);
        a.right = b;
        b.left = c;
        c.left = d;
        System.out.println(pathSum(a,22));
    }
}
