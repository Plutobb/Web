package dynamicProgramming;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int len = s.length();
        int maxLength = 1;
        int begin = 0;
        if (s.length() < 2){
            return s;
        }
        boolean[][] isHuiWen = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            isHuiWen[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)){
                    isHuiWen[i][j] = false;
                }else {
                    if (j - i < 3){//此时[i,j]构不成区间因此直接填表为true;
                        isHuiWen[i][j] = true;
                    }else {
                        isHuiWen[i][j] = isHuiWen[i+1][j-1];
                    }
                }
                if (isHuiWen[i][j] && j-i+1 > maxLength){
                    maxLength = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLength);
    }
}
