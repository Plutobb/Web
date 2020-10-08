package StringClass;

public class ReverseString {
    public static void reverseString(char[] s) {
        if (s.length <= 1){
            return;
        }
        int left = 0;
        int right = s.length-1;
        while (left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            ++left;
            --right;
        }
    }
}
