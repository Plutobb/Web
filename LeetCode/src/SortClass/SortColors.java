package SortClass;

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <=1){
            return;
        }
        int left = 0;
        int right = nums.length-1;
        for (int i = left; i <= right; i++) {
            if (nums[i] == 0){//已知值的交换可以直接赋值;
                nums[i] = nums[left];
                nums[left++] = 0;
            }else if (nums[i] == 2){
                nums[i--] = nums[right];
                nums[right--] = 2;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,1,1,0,0,0};
        sortColors(arr);
    }
}
