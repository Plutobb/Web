package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MinNumber {
    public static String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
        list.sort((s1,s2)->(s1+s2).compareTo(s2+s1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {0,2};
        System.out.println(1);
        System.out.println(minNumber(nums));
    }
}
