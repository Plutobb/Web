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

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(2147483647);
        a.right = b;
        b.left = c;
        a.left = d;
        int[] ans = findMode(e);
        System.out.println(Arrays.toString(ans));
    }
}
