package StringClass;

import java.util.LinkedList;
import java.util.List;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <1){
            return "";
        }
        List<Character> list = new LinkedList<>();
        for (char c : strs[0].toCharArray()){
            list.add(c);
        }
        List<Character> tmpList = new LinkedList<>();
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (j > list.size()-1){
                    break;
                }
                char ch = strs[i].charAt(j);
                if (list.get(j).equals(ch)){
                    tmpList.add(ch);
                }else {
                    break;
                }
            }
            list = new LinkedList<>(tmpList);
            tmpList.clear();
        }
        StringBuilder sb = new StringBuilder("");
        for (char c : list){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strings));
    }
}
