package Others;

import java.util.Arrays;

public class findMinK {
    //输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
    //解法一:最直观的就是实现一个排序,然后选出最小的k个数字,此时复杂度基于排序的复杂度最快为O(N*Log(N));
    //解法二:采用快排的思想,因为每次快排会将值进行划分,左边比基准值小,右边大,因此如果返回的基准值下标等于k-1的话左侧的就是最小的k个数字.

    private static final int K = 3;

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        findK(arr,0,arr.length-1);

        int[] ans = new int[K];

        for (int i = 0; i < K; i++) {
            ans[i] = arr[i];
        }
        System.out.println(Arrays.toString(ans));
    }

    private static void findK(int[] arr, int left, int right) {
        if (left >= right){
            return;
        }
        int mid = findKHelp(arr,left,right);
        if (mid > K){
            //需要找的数字都在左侧;
            findK(arr, left, mid-1);
        }
        if (mid < K){
            findK(arr, mid+1, right);
        }
    }

    private static int findKHelp(int[] arr, int left, int right) {
        int flag = arr[left];
        int index = left;
        while (left < right){
            while (left < right && arr[right] >= flag){
                right--;
            }
            while (left < right && arr[left] <= flag){
                left++;
            }
            swap(arr,left,right);
        }
        swap(arr,left,index);

        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

}
