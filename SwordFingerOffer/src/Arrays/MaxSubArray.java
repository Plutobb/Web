package Arrays;

public class MaxSubArray {
    //题目描述:
    /*
    输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

    要求时间复杂度为O(n)。

     

    示例1:

    输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

    解题思路:动态规划求出最优解
     */
    public static int maxSubArray(int[] array) {
        if(array==null||array.length==0)
            return Integer.MIN_VALUE;
        int endAsI=array[0];
        int result=endAsI;
        for(int i=1;i<array.length;i++){
            endAsI=endAsI+array[i]>array[i]? endAsI+array[i] : array[i];
            if(endAsI>result)
                result=endAsI;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
