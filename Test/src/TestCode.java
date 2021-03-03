import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TestCode {
    public static void moveNum(int[] arr){
        int begin = 0;
        int end = arr.length-1;
        while (begin < end){
            while (arr[begin] % 2 == 0){
                begin++;
            }
            while (arr[end] % 2 != 0){
                end--;
            }
            if (begin < end) {
                int tmp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = tmp;
            }

        }
    }
    public static void changeArrays(int[] arr1,int[] arr2){
        int[] tmp = arr1;
        arr1 = arr2;
        arr2 = tmp;

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while (sc.hasNextLine()){
            String liaoLi = sc.nextLine();
            String[] caiLiao = liaoLi.split(" ");
            for (String zhongLei : caiLiao){
                set.add(zhongLei);
            }
        }
        System.out.println(set.size());
    }

}
