import java.util.Scanner;

/*
小美和小团居住的城市有n座房子呈一条直线排列,相邻两房子间隔相同,第i座房子编号为i.小美知道小团的房子可能在某些房子中,他想买一套房子使得距离小团可能所在房子的期望距离尽可能小,
同时又不超过k元钱,于是向你求助.



输入描述
第一行2个正整数n,k如上文所述.

第二行n个整数,a1,...,an，分别为第i座房子的价格,若价格为0表示小美可能在这一房子中,且此座房子不可购买.小美出现在所有可能房子中的概率相同。

2≤n≤100,0≤ai,k≤100

输出描述
输出一个正整数,表示小团需购买的房间的编号.数据保证至少有一间房间是小美可能居住的地方且至少有一间房间小团可购买


样例输入
5 3
4 5 0 3 3
样例输出
4
 */
public class meiTuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findHouse(arr, k)+1);
    }

    private static int findHouse(int[] arr,int k){
        int indexXiaoMei = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) indexXiaoMei = i;
        }
        int right = indexXiaoMei+1;
        int left = indexXiaoMei-1;
        while (left >= 0 && right < arr.length){
            if (arr[left] <= k){
                return left;
            }else {
                left--;
            }
            if (arr[right] <= k){
                return right;
            }else {
                right++;
            }
        }
        while (left >= 0 ){
            if (arr[left] <= k){
                return left;
            }else {
                left--;
            }
        }
        while (right < arr.length){
            if (arr[right] <= k){
                return right;
            }else {
                right++;
            }
        }
        return -1;
    }
}
