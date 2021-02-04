package IntClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class findClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int size = ret.size();
        if (x < ret.get(0)){
            return ret.subList(0,k);
        }
        if (x > ret.get(size - 1)){
            return ret.subList(size - k,size);
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x){
                index = i;
            }
            if(i < arr.length -1) {
                if (arr[i] < x && arr[i + 1] > x) {
                    //如果没有x，则选出最近的数字作为下标；
                    index = (arr[i + 1] - x) - (x - arr[i]) < 0 ? i + 1 : i;
                }
            }
        }
        int low = index - 1;
        int high = index + 1;
        while (low >= 0 || high < arr.length) {
            int ans = high - low - 1;
            if (ans == k) {
                return ret.subList(low + 1, high);
            } else if (ans < k) {
                if (low < 0){
                    high++;
                }
                if (high >= arr.length){
                    low--;
                }
                if (low >= 0 && high < arr.length) {
                    if ((Math.abs(arr[high] - x)) - (Math.abs(x - arr[low])) < 0) {
                        high++;
                    } else {
                        low--;
                    }
                }
            }
        }
        return ret.subList(low + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,1,2,3,4,5};
        List list = findClosestElements(arr,7,3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
