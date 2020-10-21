package StringClass;

public class IsLongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for(int i = 0;i < name.length();i++){
            char n = name.charAt(i);
            for(; j < typed.length();j++){
                char t = typed.charAt(j);
                if (n == t){
                    j++;
                    break;
                }else {
                    char post = name.charAt(i-1);
                    if (post != t){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "alex";
        String s2 = "aaleex";
        System.out.println(isLongPressedName(s1,s2));
    }
}
