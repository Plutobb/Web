package SortClass;

import java.util.Arrays;

public class megerSort {
    /*归并排序
    简述原理:
    归并排序分为拆分和合并两个阶段,首先将数组拆分到长度为1然后两两合并,插入到新的小数组中,一次向上合并,实现有序;

     */
    public static void mergeSort(int[] n){
        mergeHelp(n,0,n.length);
    }

    private static void mergeHelp(int[] n, int low, int high) {
        if (low >= high-1) return;
        int mid = (low + high)/2;
        //这里实现数组的拆分,拆成小段;
        mergeHelp(n,low,mid);
        mergeHelp(n,mid,high);
        //这里实现了合并的过程;
        merge(n,low,mid,high);

    }

    private static void merge(int[] n, int low, int mid, int high) {
        int[] arr = new int[high-low];//新建一个数组来存放排好序的部分;
        int index = 0;
        int i = low;
        int j = mid;
        while (i < mid && j < high){//从两个数组的最小值找出最小值插入到新数组;
            if (n[i] <= n[j]){
                arr[index++] = n[i++];
            }else {
                arr[index++] = n[j++];
            }
        }
        while (i < mid){//一个数组提前遍历完后,另一个数组直接插入到新数组后面;
            arr[index++] = n[i++];
        }
        while (j < high){
            arr[index++] = n[j++];
        }
        for (int k = 0; k < arr.length; k++) {//这里将归并后的部分插入到原来的数组中
            n[low+k] = arr[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,1,8,9,7,4,6,0};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
