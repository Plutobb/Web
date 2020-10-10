package IntClass;

public class reverseInt {
    public static int reverse(int x) {
        int ans = 0;
        int flag = 1;
        if (x < 0){
            flag = -1;
            x = -x;
        }
        while (x != 0) {
            int yuShu = x % 10;
            x = x / 10;
            if (flag == 1) {
                if ((Integer.MAX_VALUE - yuShu) / 10 < ans) {
                    return 0;
                }
            }else {
                if ((Integer.MAX_VALUE - yuShu + 1) / 10 < ans){
                    return 0;
                }
            }
            ans = ans * 10 + yuShu;
        }
        return ans*flag;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(-1463847412));
    }
}
