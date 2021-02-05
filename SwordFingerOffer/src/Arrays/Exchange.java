package Arrays;

import java.util.Arrays;

public class Exchange {
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
    //这里的是不需要注意原来的奇数的顺序
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            while (nums[left] % 2 != 0 && left < right) {
                left++;
            }
            while (nums[right] % 2 == 0 &&left < right){
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
        int[] nums = {0,0,0,0,0};
        System.out.println(Arrays.toString(exchange(nums)));
    }

    public void reOrderArray(int [] array) {
        int len=array.length;
        int even=0,odd=0; //当前序列的第一个奇数和第一个偶数
        while(odd<len && even<len){
            while(even<len && array[even]%2!=0) //找到第一个偶数even
                even++;
            odd=even+1;
            //找偶数之后的第一个奇数
            while(odd<len && array[odd]%2==0)
                odd++;
            if(odd>=len)  //注意判断，防止溢出
                break;
            //把奇数取出来，从even到odd-1的元素都向后移
            int temp=array[odd];
            for(int i=odd;i>even;i--)
                array[i]=array[i-1];
            array[even]=temp; //奇数放在原来even的位置
            even++;
        }
    }
}
