import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JDTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        while (sc.hasNextInt()){
            n = sc.nextInt();
            m = sc.nextInt();
            Map<Integer,Integer> map = new HashMap<>();
            int maxKey = -1;
            int maxTime = -1;
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                map.put(num,map.getOrDefault(num,0)+1);
                if (map.get(num) > maxTime){
                    maxKey = num;
                    maxTime = map.get(num);
                }
            }
//            int max = -1;
//            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
//                if (max < entry.getValue()){
//                    max = entry.getKey();
//                }
//            }
            System.out.println(maxKey+" "+map.get(maxKey));
        }
    }
}
