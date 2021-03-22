package StringClass;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    /*
    构造最长回文子串,这个题其实需要找到出现次数为奇数的最大的字符,加上所有出现为偶数的字符,就构成了最长的回文子串
     */
    public static int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int maxJi = 0;
        for (char a : s.toCharArray()){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue() %2 !=0 && entry.getValue() > maxJi){
                maxJi = entry.getValue();
            }
        }
        int sum=0;
        int flag = 0;//因为可能出现两个最大次数的奇数,因此第一个最大奇数出现的时候讲flag置为1,后面的奇数都减一;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 == 0) {//偶数需要加起来
                sum += value;
            } else {//奇数的话不是最大的需要减去1构成偶数加入到回文序列中!
                if (value == maxJi && flag==0){
                    sum += value;
                    flag = 1;
                }else {
                    sum += value-1;
                }

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String str = "abccccdd";
        System.out.println(longestPalindrome(str));
    }
}

