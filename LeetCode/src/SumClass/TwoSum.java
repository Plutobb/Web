package SumClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i; j < nums.length-1; j++) {
                if (nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        while (left < right){
            if (nums[left] + nums[right] > target){
                right--;
            }else if (nums[left] + nums[right] < target){
                left++;
            }else {
                ans[0] = left;
                ans[1] = right;
                break;
            }
        }
        return ans;
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,7,5,3,6,4};
        System.out.println(Arrays.toString(twoSum(nums,7)));
    }
}
