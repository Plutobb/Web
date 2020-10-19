package StringClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        LinkedList<Character> list1 = new LinkedList<>();
        LinkedList<Character> list2 = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#'){
                if (list1.size() > 0){
                    list1.removeLast();
                }
            }else {
                list1.add(c);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c == '#'){
                if (list2.size() > 0){
                    list2.removeLast();
                }
            }else {
                list2.add(c);
            }
        }
        if (list1.size() == list2.size()){
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))){
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }
}
