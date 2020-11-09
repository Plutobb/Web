package ArraysClass;

import java.util.Arrays;
import java.util.LinkedList;

public class Insert {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ansList = new LinkedList();
        if (intervals.length == 0){
            ansList.add(newInterval);
        }
        if (newInterval.length == 0){
            return intervals;
        }
        int newBegin = -1;
        int newEnd = -1;
        for (int i = 0; i < intervals.length; i++) {
            int begin = 0;
            int end = 1;
            if (newInterval[begin] > intervals[i][end]){
                ansList.add(intervals[i]);
                if (i == intervals.length-1){
                    ansList.add(newInterval);
                }
            }else if (newInterval[end] < intervals[i][begin]){
                ansList.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    ansList.add(intervals[j]);
                }
                break;
            } else if (newInterval[begin] >= intervals[i][begin] && newInterval[end] <= intervals[i][end]){
                for (int j = i; j < intervals.length; j++) {
                    ansList.add(intervals[j]);
                }
                break;
            }else if (newInterval[begin] <= intervals[i][begin] && newInterval[end] >= intervals[i][end]){
                newBegin = newInterval[begin];
                newEnd = newInterval[end];
            } else if (newInterval[begin] >= intervals[i][begin] && newInterval[end] > intervals[i][end]){
                newBegin = intervals[i][begin];
                newEnd = newInterval[end];
            }else if (newInterval[begin] <= intervals[i][begin] && newInterval[end] <= intervals[i][end]){
                newBegin = newInterval[begin];
                newEnd = intervals[i][end];
            }
            if (newBegin != -1 && newEnd != -1) {
                while (true) {
                    if (i == intervals.length - 1) {
                        ansList.add(new int[]{newBegin, newEnd});
                        break;
                    }
                    i++;
                    if (newEnd < intervals[i][begin]) {
                        ansList.add(new int[]{newBegin, newEnd});
                        for (; i < intervals.length; i++) {
                            ansList.add(intervals[i]);
                        }
                        break;
                    } else if (newEnd >= intervals[i][begin] && newEnd <= intervals[i][end]) {
                        newEnd = intervals[i][end];
                    }
                }
            }
        }
        int[][] ans = new int[ansList.size()][];
        return ansList.toArray(ans);
    }


    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] a = {{1,5}};
        int[] arr2 = {2,3};
        System.out.println(Arrays.deepToString(insert(arr1, arr2)));
    }
}
