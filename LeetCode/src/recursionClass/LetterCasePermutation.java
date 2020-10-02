package recursionClass;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String S) {
        StringBuilder sb = new StringBuilder(S.toLowerCase());
        List<String> list = new LinkedList<>();
        letterCasePermutationHelper(sb,0,list);
        return list;
    }
    public static List<String> letterCasePermutationHelper(StringBuilder S,int index,List<String> list) {
        if (index >= S.length()){
            String ans = S.toString();
            list.add(ans);
            return null;
        }
        if (S.charAt(index)>='0' &&S.charAt(index) <='9'){
            letterCasePermutationHelper(S,index+1,list);
        }else {
            //将大写字母改为小写;
            String string = S.substring(index,index+1).toLowerCase();
            S.replace(index,index+1,string);
            letterCasePermutationHelper(S,index+1,list);
            //回溯到大写;
            String string2 = S.substring(index,index+1).toUpperCase();
            S.replace(index,index+1,string2);
            letterCasePermutationHelper(S,index+1,list);
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }
}
