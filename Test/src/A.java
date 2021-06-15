import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }

    public static void main(String[] args) {
//        A<String> a = new A<>("abc");
//        System.out.println(a.value);
//        System.out.println(a.get());
        int[] num = {1, 5, 4, 9, 3, 7, 0};
        quickSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));

        List<Integer> list = new ArrayList<Integer>();

    }

    private static void quickSort(int[] num, int left, int right) {
        if (left >= right){
            return;
        }
        int mid = quickSortHelp(num,left,right);
        quickSort(num, mid+1, right);
        quickSort(num, left, mid-1);
    }

    private static int quickSortHelp(int[] num, int left, int right) {
        int flag = num[left];
        int index = left;
        while (left < right){
            while (left < right && num[right] <= flag){
                right--;
            }
            while (left < right && num[left] >= flag){
                left++;
            }
            swap(num,left,right);
        }
        swap(num,index,left);
        return left;
    }

    private static void swap(int[] num, int right, int left) {
        int tmp = num[left];
        num[left] = num[right];
        num[right] = tmp;
    }


}
