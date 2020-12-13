public class myToString {
    public static void myToString(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length -1)
                System.out.print(",");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] array= {};
        myToString(array);
    }
}
