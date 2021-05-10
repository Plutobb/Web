package TopK;

public class findKthLargest {
    public static void main(String[] args) {
        int[] num = {3,2,1,5,6,4};
        System.out.println(findKthLargest(num, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        return nums[k];
    }
}
