import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int[] a = {5,3,4,1,8,6};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right){
            return;
        }
        int mid = help(a,left,right);
        quickSort(a,mid+1,right);
        quickSort(a,left,mid-1);
    }

    private static int help(int[] a,int left,int right) {
        int index = left;
        int flag = a[left];
        while (left < right){
            while (a[right] > flag && left < right){
                right--;
            }
            while (a[left] < flag && left < right){
                left++;
            }
            swap(a,left,right);
        }
        swap(a,index,left);
        return left;
    }

    private static void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }
}
