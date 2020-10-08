package StringClass;

import java.util.LinkedList;
import java.util.List;

public class Convert {
    public static String convert(String s, int numRows) {
        if (numRows < 2){
            return s;
        }
        List<StringBuilder> list = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()){
            list.get(i).append(c);
            if (i == 0 || i == numRows-1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder stringBuilder : list){
            ans.append(stringBuilder);
        }
        return ans.toString();
    }

    public static void main(String[] args) {

    }
}
