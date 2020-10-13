package StringClass;

import javax.security.auth.login.CredentialException;

import static StringClass.Convert.convert;

public class MyAtoi {
    public int myAtoi(String s) {
        int i;
        int flag = 1;
        StringBuilder sb = new StringBuilder("");
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                continue;
            }else {
                break;
            }
        }
        if (i == s.length()){
            return 0;
        }else {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                if (s.charAt(i) == '-'){
                    flag = -1;
                }
                sb.append(s.charAt(i));
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) >= '0' && s.charAt(j) <= '9'){
                        sb.append(s.charAt(j));
                    }else {
                        break;
                    }
                }
            }else {
                return 0;
            }
        }
        long ans;
        try {
            ans = Long.parseLong(sb.toString());
            if (ans > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        } catch (NumberFormatException e) {
            if (sb.length() ==1){
                return 0;
            }else {
                if (flag == 1){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("20000000000"));
    }
}
