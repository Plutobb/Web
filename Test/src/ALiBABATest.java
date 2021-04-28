import java.util.Scanner;

public class ALiBABATest {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            help(arr,x1-1,y1-1,x2-1,y2-1,n,m,0,0);
        }
    }

    private static void help(int[][] arr, int x1, int y1, int x2, int y2,int n,int m,int flag,int ans) {
        int num1 = arr[x1][y1];
        if (x1 == x2 && y1 == y2){
            System.out.println(ans);
            return;
        }
        if (y1-1 >=0 && arr[x1][y1-1] >= num1 && flag!=2){
            flag = 1;
            help(arr, x1, y1-1, x2, y2,n,m,flag,ans+1);
            flag = 1;
            help(arr, x1, y1+1, x2, y2,n,m,flag,ans-1);
        }
        if (y1+1 < m && arr[x1][y1+1] >= num1&& flag!=1){
            flag = 2;
            help(arr, x1, y1+1, x2, y2, n, m,flag,ans+1);
            flag = 2;
            help(arr, x1, y1-1, x2, y2, n, m,flag,ans-1);
        }
        if (x1+1 < n && arr[x1+1][y1] >= num1&& flag!=4){
            flag = 3;
            help(arr, x1+1, y1, x2, y2, n, m,flag,ans+1);
            flag = 2;
            help(arr, x1-1, y1, x2, y2, n, m,flag,ans-1);
        }
        if (x1-1 >=0 && arr[x1-1][y1] >= num1&& flag!=3){
            flag = 4;
            help(arr, x1-1, y1, x2, y2, n, m,flag,ans+1);
            flag = 4;
            help(arr, x1+1, y1, x2, y2, n, m,flag,ans-1);
        }
        return;
    }


}
