package DSF;

import java.util.Arrays;
import java.util.LinkedList;

public class pondSizes {
    //池塘的大小问题
    /*
    你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。
    由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
    编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。

    思路:
    找到第一个为0的池塘地址,开始进行深度优先搜索!为了防止以及搜索过的池塘影响可以把搜索过的位置置为-1;
     */
    public static int[] PondSizes(int[][] land) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int size = findSize(land,i,j);
                if (size != 0){
                    list.add(size);
                }
            }
        }
        return list.stream().mapToInt(Integer::valueOf).sorted().toArray();
    }

    private static int findSize(int[][] land,int i,int j) {
        int sum = 0;
        if (i<0||i>land.length-1 || j<0||j>land[0].length-1||land[i][j] != 0){
            return sum;
        }
        sum++;
        land[i][j] = -1;//走过的路径修改为-1;
        sum += findSize(land, i+1, j);
        sum += findSize(land, i-1, j);
        sum += findSize(land, i, j+1);
        sum += findSize(land, i, j-1);
        sum += findSize(land, i+1, j+1);
        sum += findSize(land, i+1, j-1);
        sum += findSize(land, i-1, j+1);
        sum += findSize(land, i-1, j-1);

        return sum;

    }

    public static void main(String[] args) {
        int[][] land = {
                {0,1,2,3,4},
                {0,1,0,3,4},
                {0,2,0,3,4},
                {0,1,1,3,0}
        };
        System.out.println(Arrays.toString(PondSizes(land)));
    }

}
