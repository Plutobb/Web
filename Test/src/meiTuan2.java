import java.util.Scanner;

public class meiTuan2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[1000];
        for (int i = 0; i < n; i++) {
            int mei = sc.nextInt();
            arr[mei] = arr[mei] -1;
        }
        for (int i = 0; i < m; i++) {
            int tuan = sc.nextInt();
            arr[tuan] = arr[tuan]+1;
        }

        int index = 0;
        int maxScore=Integer.MIN_VALUE;
        while (index < arr.length){
            while (index < arr.length && arr[index] == 0){
                index++;
            }
            int leftSum = 0;
            int rightSum = 0;
            if (index < arr.length) {
                for (int i = index; i >= 0; i--) {
                    if (arr[i] == 0) {
                        continue;
                    }
                    leftSum = leftSum + arr[i];
                }
            }
            for (int i = index+1; i < arr.length; i++) {
                if (arr[i] == 0){
                    continue;
                }
                rightSum = rightSum + arr[i]*2;
            }
            if (rightSum+leftSum > maxScore){
                maxScore = rightSum + leftSum;
            }
            index++;
        }

        System.out.println(maxScore);
    }


}
