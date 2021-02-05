package Arrays;

import java.util.Arrays;

public class Exchange {
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            while (nums[left] % 2 != 0) {
                left++;
            }
            while (nums[right] % 2 == 0){
                right--;
            }

            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
