package TreeClass;

import javax.security.auth.login.CredentialException;

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
        if ("".equals(string)){
            return true;
        }
        if (left >= right){
            return true;
        }
        if (string.charAt(left) == string.charAt(right)){
            return isHuiWen(string, left+1, right-1);
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        String string = "";
        System.out.println(longestPalindrome(string));
        System.out.println(isHuiWen(string,0,string.length()-1));
    }
}
