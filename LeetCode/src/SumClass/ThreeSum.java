package SumClass;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        if (nums.length < 3){
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {//此时没有结果了,直接结束循环;
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]){//第一个数去重;
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if (sum ==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum > 0){
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return ans;
    }
}
