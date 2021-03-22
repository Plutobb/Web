package SortClass;

import java.util.Arrays;

public class QuickSort {
    /*快排实现
    简述快排原理:
    找到一个基准值,然后从数组的两侧开始遍历,找到左侧比基准值大的(此处实现的是升序),右侧比基准值小的,然后进行交换,然后继续遍历,一遍遍历之后
    基准值左侧的数字都是比基准值小的,右边都是比基准值大的,然后返回基准值下标,递归下标左右侧的输出重复上面过程,即可实现快速排序
    时间复杂度O(n*log(n)) 最坏O(n^2) 空间复杂度O(log(n) ~ n) 属于不稳定排序
     */
    public static void quicklySort(int[] n){
        qSort(n,0,n.length-1);
    }

    private static void qSort(int[] n,int left,int right) {
        if (left < right){
            int flagIndex = help(n, left, right);
            qSort(n,left,flagIndex-1);
            qSort(n,flagIndex+1,right);
        }
    }

    private static int help(int[] n,int left,int right) {
        int flag = n[left];//拿第一个数字作为基准值
        while (left < right){
            while (left < right && n[right] >= flag) right--;//切记先从右侧开始交换;
            swap(n,left,right);
            while (left < right && n[left] <= flag) left++;
            swap(n,left,right);
        }
        //交换基准值,和最中间的数字,并返回中位置的下标;
        return left;
    }

    private static void swap(int[] n, int left, int right) {
        int tmp = n[left];
        n[left] = n[right];
        n[right] = tmp;
    }
    private static void swap1(int[] n,int i,int j){
        n[i] = n[i]^n[j];
        n[j] = n[i]^n[j];
        n[i] = n[i]^n[j];
    }
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,5,6,9,7,8};
        quicklySort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
