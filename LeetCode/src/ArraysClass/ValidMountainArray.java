package ArraysClass;

public class ValidMountainArray {
    public static boolean validMountainArray(int[] A) {
        boolean rise = true;
        if (A.length < 3){
            return false;
        }
        for (int i = 0; i < A.length-1; i++) {
            if (rise){
                if (A[i] == A[i+1]){
                    return false;
                }else if (A[i] > A[i+1]){
                    if (i == 0){
                        return false;
                    }
                    rise = false;
                }
            }else {
                if (A[i] == A[i+1]){
                    return false;
                }else if (A[i] < A[i+1]){
                    return false;
                }
            }
        }
        return !rise;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(validMountainArray(arr));
    }
}
