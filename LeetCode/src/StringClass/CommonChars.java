package StringClass;

import java.util.LinkedList;
import java.util.List;

public class CommonChars {
    public static List<String> commonChars(String[] A) {
        if (A.length < 1){
            return null;
        }
        List<Character> list = new LinkedList<>();
        List<Character> tmpList = new LinkedList<>();
        List<String> ans = new LinkedList<>();
        for (char c : A[0].toCharArray()){
            list.add(c);
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                char ch = A[i].charAt(j);
                if (list.contains(ch)){
                    list.remove(list.indexOf(ch));
                    tmpList.add(ch);
                }
            }
            list = new LinkedList<>(tmpList);
            tmpList.clear();
        }
        for (char c : list){
            ans.add(c+"");
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] A = {};
        System.out.println(commonChars(A));
    }
}
