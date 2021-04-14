import java.util.Scanner;

public class meituan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        String stringNum = Integer.toString(num);
        StringBuilder sb = null;
        if (stringNum.length() < n){
            sb = new StringBuilder(stringNum);
            for (int i = 0; i < n-stringNum.length(); i++) {
                sb.insert(0,'0');
            }
        }

        int index = 0;
        while (sb != null && index < sb.length()){
            if (index+3 < sb.length()) {
                String substring = sb.substring(index, index + 3);
                int subInt = Integer.parseInt(substring);
                if (subInt == 11 || subInt == 111){
                    sb.delete(index,index+3);
                    index = 0;
                }else{
                    index++;
                }
            }else {
                break;
            }
        }
        if (sb == null){
            System.out.println(0);
        }else {
            int sum = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0'){
                    sum++;
                }else {
                    sum--;
                }
            }
            System.out.println(sum);
        }
    }
}
