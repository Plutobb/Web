package IntClass;

public class nineNum {
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            int tenWei =  i / 10;
            int geWei = i % 10;
            if (tenWei == 9) ans++;
            if (geWei == 9) ans++;
        }
        System.out.println(ans);
    }
}