package Arrays;

public class FindInTwoDimensionalArray {
    //题目描述：
    //1.
    //在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    //请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    //
    /*
    解题思路:
        根据题目中的递增规律可知,右上角的数字是一行中的最大值,一列中的最小值,因此每次拿右上角的数字去比和寻找值比较,
        1.如果这个值等于寻找值就找到了
        2.如果这个值大于寻找值说明这一列都大于寻找值,就可以排除这列.
        3.如果这个值小于寻找值说明这一行都小于寻找值,就可以排除这一行.
        4.以此类推直到找对寻找值.
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length <= 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length-1;
        while (row < matrix.length && col >= 0){
            int flag = matrix[row][col];
            if (flag > target){
                //排除了这一列,因此列数减一.
                col--;
            }else if (flag < target){
                //排除这一行,因此行数加一.
                row++;
            }else {
                //相等说明找到了.
                return true;
            }
        }
        return false;
    }
}
