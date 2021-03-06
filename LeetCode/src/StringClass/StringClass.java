package StringClass;

import javax.security.auth.login.CredentialException;
import java.util.HashSet;
import java.util.Set;

public class StringClass {
    //寻找最长子回文串;
    public static String longestPalindrome(String s) {//此方法超时;
        int length = s.length();
        while (length > 0) {
            for (int i = 0; i <= s.length() - length; i++) {
                String ans = s.substring(i,i+length);
                Boolean isHuiWen = isHuiWen(ans, 0, ans.length() - 1);
                if (isHuiWen) {
                    return ans;
                }
            }
            length--;
        }
        return "";
    }
    public static Boolean isHuiWen(String string,int left,int right){
        while (left <right){
            if (string.charAt(left) != string.charAt(right)){
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }
    //寻找最长中心子串--中心扩散法



    public static int NumJewelsInStones(String J, String S) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i <S.length() ; i++) {
            if (set.contains(S.charAt(i))){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String string = "";
        System.out.println(longestPalindrome(string));
        System.out.println(isHuiWen(string,0,string.length()-1));
    }
}
