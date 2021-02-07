package Arrays;

public class MaxSubArray {
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
