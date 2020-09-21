package dynamicProgramming;

import java.util.HashMap;

public class fibonacci {
    //斐波那契并不是动态规划问题,没有涉及到求最值,但是含有大量的重叠子问题以及状态转移方程,可以更好地理解动态规划问题.
    public static int fiBoNaCi(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fiBoNaCi(n-1) + fiBoNaCi(n-2);
    }
    //上面是最原始的递归求解斐波那契,由于出现了很多重复子问题,导致时间复杂度异常的高,时间复杂度为O(2^n),空间复杂度为O(1)
    //为了降低时间复杂度,先采用空间换时间的方法,使用哈希表缓存已将计算过的问题的解.
    static HashMap<Integer,Integer> map =new HashMap<>();
    public static int fiBoNaCi2(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        int sum = fiBoNaCi2(n-1)+fiBoNaCi2(n-2);
        map.put(n,sum);
        return sum;
    }
    //以上方法时间复杂度由于哈希表缓存了很多子问题的解,所以是线性的,时间复杂度为O(n),空间复杂度有所提高为O(n)
    //接下来是数学方法,根据斐波那契数列,可以推导出 f(3) = f(2) + f(1) 因此可以通过计算来直接求出f(n)的值.
    public static int fiBoNaCiByMath(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int pre = 1;
        int next = 2;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = pre + next;
            pre = next;
            next = ans;
        }
        return ans;
    }
    //这个算法的时间复杂度为O(n),空间复杂度为O(1),此处就体会到了算法的巧妙之处,相同的问题,不同的算法有着不同的效率.
    //上面的算法就体现了自底向上的思想,虽然并不是动态规划,但有着异曲同工之妙.
    //接下来写一个简单的动态规划问题,三角形的最小路径和.
    //2
    //3 4
    //6 5 7
    //4 1 8 3
    //采用二维数组来存储这个三角形
    private static int[][] length = {
            {2,0,0,0},
            {3,4,0,0},
            {6,5,7,0},
            {4,1,8,3}
    };
    //首先采用递归的方法来求解
    public static int findMinLength(int i,int j){
        int col = 4;
        if (i >= col-1){
            return 0;
        }
        int leftLength = findMinLength(i+1,j) + length[i+1][j];
        int rightLength =findMinLength(i+1,j+1) + length[i+1][j+1];
        return Math.min(leftLength,rightLength);
    }
    //递归求解同样存在重复子问题,因此并不是很好的选择,一样可以使用哈希表来缓存结果,不再赘述.
    //直接来看动态规划如何求解
    //谨记动态规划的要点,"自底向上"
    public static int traverse(){
        int row = 4;
        int[] min = length[row-1];
        for (int i = row-2; i >= 0; i--) {
            for (int j = 0; j < length[i].length; j++) {
                if (length[i][j] == 0){
                    continue;
                }
                min[j] = Math.min(min[j],min[j+1]) + length[i][j];//底下两个最小值加上此节点的值就是当前节点的最短路径长度.
            }
        }
        return min[0];
    }
    public static void main(String[] args) {
        int min = traverse();
        System.out.println(min);
    }
}
