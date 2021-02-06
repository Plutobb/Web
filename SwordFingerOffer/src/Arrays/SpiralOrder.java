package Arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class SpiralOrder {
    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    // 例如，如果输入如下
    // 4 X 4矩阵：
    // 1  2  3  4
    // 5  6  7  8
    // 9  10 11 12
    // 13 14 15 16
    // 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
    public static int[] spiralOrder(int[][] matrix) {
        LinkedList<Integer> ans = new LinkedList<>();
        int row = matrix.length;//行数
        if (row == 0)
            return new int[0];
        int col = matrix[0].length;//列数
        for (int i = 0; row>i*2 && col>i*2; i++) {
            int endX = col - 1 -i;//结束的列数
            int endY = row - 1 -i;//结束的行数

            for (int j = i; j <= endX; j++) {//从左到右打印行
                ans.add(matrix[i][j]);
            }
            for (int j = i+1; j <= endY; j++) {//从上到下打印列
                ans.add(matrix[j][endX]);
            }
            if (endY > i)
                for (int j = endX-1; j >= i; j--) {
                    ans.add(matrix[endY][j]);
                }
            if (endX > i)
                for (int j = endY-1; j > i; j--) {
                    ans.add(matrix[j][i]);
                }
        }
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}};
        System.out.println(Arrays.toString(spiralOrder(new int[0][])));
    }
}
