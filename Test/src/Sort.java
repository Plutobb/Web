import java.util.Arrays;

public class Sort {
    //复习一下排序
    //1.插入排序
    public static void intSort(int[] n){
        for (int i = 1; i < n.length; i++) {
            int tmp = n[i];
            int j = i - 1;
            for (;j>=0 && n[j] > tmp;j--){
                n[j+1] = n[j];
            }
            n[j+1] = tmp;
        }
    }
    //2.希尔排序
    //希尔排序是基于插入排序的,代码很类似;
    public static void shellSort(int[] n){
        int gap = n.length;
        while (gap > 1){
            inSort(n,gap);
            gap = gap / 2;
        }
        inSort(n,1);
    }

    private static void inSort(int[] n, int gap) {
        for (int i = 0; i < n.length; i++) {
            int tmp = n[i];
            int j = i - gap;
            for(;j>=0 && n[j] > tmp; j-=gap){
                n[j+gap] = n[j];
            }
            n[j+gap] = tmp;
        }
    }

    //3.选择排序
    public static void selectSort(int[] n){
        int maxIndex = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = 1; j < n.length-i; j++) {
                if (n[j]>n[maxIndex]){
                    maxIndex = j;
                }
            }
            swap(n,maxIndex,n.length-1-i);
        }
    }

    private static void swap(int[] n, int maxIndex, int i) {
        int tmp = n[maxIndex];
        n[maxIndex] = n[i];
        n[i] = tmp;
    }

    //4.堆排序
    //堆排序的原理和选择排序很类似，不过是在堆中寻找最大的数字交换；
    //堆本来是树的形状，但是可以在数组中按照下标形成一颗树，因此可以实现堆排序。
    public static void heapSort(int[] n){
        if (n == null||n.length == 0){
            return;
        }
        //这个长度来区分排序与未排序的数字；
        buildHeap(n,n.length);
        for (int i = 0; i < n.length; i++) {
            swap(n,0,n.length-1-i);
            reBuildHeap(n,n.length-1-i,0);
        }
    }
    private static void buildHeap(int[] n, int size) {
        for (int i = (size-1)/2; i >= 0; i--) {
            //从最后一个非叶子节点来进行重建，也就是自底向上；
            reBuildHeap(n,size,i);
        }
    }

    private static void reBuildHeap(int[] n, int size,int parent) {
        int left = parent*2+1;
        while (left < size){
            int right = parent*2+2;
            int maxIndex = left;
            if (right < size && n[right] > n[left]){
                maxIndex = right;
            }
            if (n[parent] >= n[maxIndex]){
                break;
            }
            swap(n,parent,maxIndex);
            parent = maxIndex;
            left = maxIndex*2+1;
        }
    }

    //快速排序
    public static void quickSort(int[] a, int left, int right){
        if (left >= right){
            return;
        }
        int mid = quickSortHelp(a,left,right);
        quickSort(a,left,mid-1);
        quickSort(a,mid+1,right);
    }

    private static int quickSortHelp(int[] a, int left, int right) {
        int flag = a[left];
        int index = left;
        while (left < right){
            while (left < right && a[right] >= flag){
                right--;
            }
            while (left < right && a[left] <= flag){
                left++;
            }
            swap(a,left,right);
        }
        swap(a,index,left);
        return left;
    }

    public static void main(String[] args) {
        int[] num = {4,7,5,3,2,8,6,1};
        quickSort1(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }
    public static void quickSort1(int[] num,int left,int right){
        if(left > right){
            return;
        }
        int mid = quickSortHelp1(num,left,right);
        quickSort(num,left,mid-1);
        quickSort(num,mid+1,right);
    }

    public static int quickSortHelp1(int[] num,int left,int right){
        int flag = num[left];
        int index = left;
        while(left < right){
            while(left < right && num[right] >= flag){
                right--;
            }
            while(left < right && num[left] <= flag){
                left++;
            }
            swap1(num,left,right);
        }
        swap(num,index,left);
        return left;
    }

    //堆排序;

    public static void heapSort1(int[] arr){

    }

    public static void swap1(int[] num,int left,int right){
        int tmp = num[left];
        num[left]  = num[right];
        num[right] = tmp;
    }
}
