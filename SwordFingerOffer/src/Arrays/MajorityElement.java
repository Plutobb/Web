package Arrays;

public class MajorityElement {
    /*
     题目描述：

    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    例如：输入如下所示的一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */
    /*
    三种解法
    第一种:排序,排序后遍历.
    第二种:使用HashMap来存储出现的次数,时间复杂度为O(0),但空间复杂度也为O(0);
    第三种:(最优解)如果存在这个数字则这个数字出现的次数一定是比其他数字的总和要多.
    因此两个变量result和times,一个记录数字,另一个记录出现的次数,如果下一个数字和result不同就times-1,
    当times=0时result变为下一个数字,并将times置为1,到最后result就是要找的数字;
     */
    public static int majorityElement(int[] nums) {
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0){
                result = nums[i];
                times = 1;
                continue;
            }
            if (nums[i] != result){
                times--;
            }else {
                times++;
            }
        }
        //力扣上的是总存在这个数字因此这个结果一定是对的
        //但是如果不一定存在这个数字的话,还需要判断这个数字是否出现次数超过一半.
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5};
        System.out.println(majorityElement(nums));
    }
}
