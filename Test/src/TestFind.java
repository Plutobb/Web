import java.util.Arrays;

public class TestFind {

    //有两个整型数组，写代码它们的交集（用熟悉的开发语言或伪代码）
    //样例：
    //a = [1, 3, 8, 4, 6]
    //b = [3, 4, 9]
    //结果集：[3, 4]

    public static void main(String[] args) {
        int[] a = {1,3,8,4,6};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right){
            return;
        }
        int mid = fast(a,left,right);
        quickSort(a,left,mid-1);
        quickSort(a,mid+1,right);
    }

    public static int fast(int[] num,int left,int right){
        int index = left;
        int flag = num[left];
        while (left < right){
            while (num[right] >= flag && left < right){
                right--;
            }
            while (num[left] <= flag && left <right){
                left++;
            }
            swap(num,left,right);
        }
        swap(num,index,left);
        return left;
    }

    private static void swap(int[] num, int left, int right) {
        int tmp = num[left];
        num[left] = num[right];
        num[right] = tmp;
    }

}
