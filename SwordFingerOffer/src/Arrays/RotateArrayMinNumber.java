package Arrays;

public class RotateArrayMinNumber {
    /*题目介绍:
        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
        例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

      解题思路:
        简单的直接遍历就不再介绍了,不是本题的初衷,考虑使用双指针来,时间复杂度为O(log n).
        可以把旋转后的数组分为两个从小到大的有序数组.
        左侧low指针指向第一个,右侧high指针指向最后一个,然后mid为两数组的中间数字.
            1.如果mid > low 说明最小数字在mid右侧,因此low = mid;
            2.如果mid < low 说明最小数字在mid左侧,因此high = mid;
            3.直到low + 1 == high 时 high就指向我们需要的最小数字.
         上面没有包含特殊情况:
            1.没有进行旋转的数组,例如旋转个数为0.
                这时 low < high 直接返回 low 就可以了
            2.当旋转后mid == low == high时这时就没办法使用指针寻找了,需要退而求次,使用顺序查找.

    */
    public int minNumberInRotateArray(int [] array) {
        /*
        三种情况：
        （1）把前面0个元素搬到末尾，也就是排序数组本身，第一个就是最小值
        （2）一般情况二分查找，当high-low=1时，high就是最小值
        （3）如果首尾元素和中间元素都相等时，只能顺序查找
        */
        int len=array.length;
        if(len==0) {
            return 0;
        }
        int low=0,high=len-1;
        if(array[low]<array[high]){
            //排序数组本身
            return array[low];
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(array[low]==array[mid] && array[high]==array[mid]) {
                return minInOrder(array);
            }
            if(array[mid]>=array[low]) {
                low=mid;
            } else if(array[mid]<=array[high]) {
                high=mid;
            }
            if(high-low==1) {
                return array[high];
            }
        }
        return -1;
    }
    public int minInOrder(int [] array) { //顺序查找
        int min=array[0];
        for(int num:array){
            if(num<min) {
                min=num;
            }
        }
        return min;
    }

    //简洁解法
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = i + (j-i) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }

}
