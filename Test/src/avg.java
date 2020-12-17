public class avg {
    public static float avg(int[] num){
        int sum = 0;
        for (int n : num){
            sum += n;
        }
        return (float) sum / num.length;
    }

    public static int sum(int[] num){
        int sum = 0;
        for (int n : num){
            sum += n;
        }
        return sum;
    }

    public static int[] transform(int[] num){
        for (int i = 0; i < num.length; i++) {
            num[i] *= 2;
        }
        return num;
    }

    public static void printArray(int[] num){
        for (int value : num) {
            System.out.print(value);
        }
    }
    public static int[] createInt(){
        int[] arrays = new int[100];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = i + 1;
        }
        return arrays;
    }

    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static Boolean judge_asc(int[] arrays){
        for (int i = 0; i < arrays.length-1; i++) {
            if (arrays[i] > arrays[i+1]){
                return false;
            }
        }
        return true;
    }

    public static int findBy2(int[] arr,int toFind){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] > toFind){
                right = mid-1;
            }else if (arr[mid] < toFind){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static int[] copyOf(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static void myToString(int[] num){
        System.out.print("[");
        for (int i = 0; i < num.length; i++) {
            if (i != num.length-1) System.out.print(num[i] + ",");
            else System.out.print(num[i]);
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        myToString(new int[]{1, 2, 3, 4, 5});
    }

}
