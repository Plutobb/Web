package TreeClass;

import java.util.*;

public class TreeClass {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

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

    public static Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new LinkedList<>();
        if (root == null){
            return null;
        }
        queue.add(root);
        Node last = root;
        Node nlast = root;
        Node n = new Node(-1);
        while (!queue.isEmpty()){
            Node front = queue.poll();
            list.add(front);
            if (front.left != null){
                queue.add(front.left);
                nlast = front.left;
            }
            if (front.right != null){
                queue.add(front.right);
                nlast = front.right;
            }
            if (front == last){
                list.add(n);
                last = nlast;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (i == list.size()-1){
                node.next = null;
                break;
            }
            if (node == n){
                continue;
            }
           Node next = list.get(i+1);
           if (next != n){
               node.next = next;
           }
        }
        return root;
    }
    public static void cengXuBianLi(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return ;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode front = queue.poll();
            if (front.left != null){
                queue.add(front.left);
            }
            if (front.right != null){
                queue.add(front.right);
            }
            System.out.print(front.val);
        }
    }
    public static void cengXuBianLiPrintByCeng(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = root;
        TreeNode nlast = root;
        if (root == null){
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode front = queue.poll();
            System.out.print(front.val);
            if (front.left != null){
                queue.add(front.left);
                nlast = front.left;
            }
            if (front.right != null){
                queue.add(front.right);
                nlast = front.right;
            }
            if (front == last){
                System.out.println();
                last = nlast;
            }
        }
    }
    public static void cengXuBianLiPrintByCengMethod2(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null){
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            System.out.println();
        }
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        insertIntoBSTHelper(root,val);
        return root;
    }
    public static void insertIntoBSTHelper(TreeNode root,int val){
        //节点插入右子树
        if (root.val < val && root.right == null){
            root.right = new TreeNode(val);
            return;
        }
        //节点插入左子树
        if (root.val > val && root.left == null){
            root.left = new TreeNode(val);
            return;
        }
        //节点相等情况
        if (root.val == val){
            TreeNode node = new TreeNode(val);
            node.left = root.left;
            root.left = node;
            return;
        }
        if (root.val < val){
            insertIntoBSTHelper(root.right,val);
        }
        if (root.val > val){
            insertIntoBSTHelper(root.left, val);
        }
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        preorderTraversalHelp(root,ans);
        return ans;
    }

    private static void preorderTraversalHelp(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }
        ans.add(root.val);
        preorderTraversalHelp(root.left,ans);
        preorderTraversalHelp(root.right,ans);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
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
     //   insertIntoBST(null,2);
        System.out.println(preorderTraversal(a));
    }
}
