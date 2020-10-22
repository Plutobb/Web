package StringClass;

import ListClass.ListClass;

import java.util.*;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String S) {
        Map<Character,int[]> map = new HashMap<>();
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(S.charAt(i))){//图中没有说明 第一次出现这个字符;
                int[] index = new int[2];
                index[0] = i;//数组的第一个值为 字符出现的第一次位置
                index[1] = i;//数组的第二个值为 字符最后出现的位置;
                map.put(S.charAt(i),index);
            }else {
                //表中已经存在的话就改最后出现的位置;
                int[] index = map.get(S.charAt(i));
                index[1] = i;
            }
        }
        int begin = -2;
        int end = -2;
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))){
                list.add(map.get(S.charAt(i)));
                map.remove(S.charAt(i));
            }
        }
        for(int i = 0 ; i < list.size(); i++){
            int[] index = list.get(i);
            if (begin == -2){
                begin = index[0];
                end = index[1];
            }
            if (index[0] > begin && index[0] < end){
                if (index[1] > end){
                    end = index[1];
                }
            }
            if (index[0] == end +1){
                ans.add(end - begin + 1);
                begin = index[0];
                end = index[1];
            }
        }
        if (end == S.length()-1){
            ans.add(end - begin + 1);
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        String  s = "ababcbacadefegdehijhklij";
        partitionLabels(s);
    }
}
