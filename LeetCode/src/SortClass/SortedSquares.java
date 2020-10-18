package SortClass;

import java.util.Arrays;

public class SortedSquares {
    public static int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ans[i] = A[i] * A[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,1,0,8,9};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}
