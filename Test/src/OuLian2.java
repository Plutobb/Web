import java.util.Random;

public class OuLian2 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            long a = sc.nextLong();
//            long b = sc.nextLong();
//            System.out.println(a*b);
//        }

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(3)+1);
        }
    }
}
