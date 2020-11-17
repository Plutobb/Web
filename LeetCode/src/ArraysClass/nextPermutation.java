package ArraysClass;

import java.util.Arrays;

public class nextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length == 0){
            return;
        }
        int i;
        for (i = nums.length-1; i >= 0 ; i--) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                if (i != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                }
                for (int j = i; j < nums.length-1; j++) {
                    for (int k = i; k < nums.length-1; k++) {
                        if (nums[k] > nums[k + 1]) {
                            int tmp2 = nums[k];
                            nums[k] = nums[k + 1];
                            nums[k + 1] = tmp2;
                        }
                    }
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
