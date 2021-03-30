package Other;

public class MaxArea {

    //最大容纳水量
    public static int maxArea01(int[] height) {
        //思路：目前没好的思路采用暴力解法，找出所有可能出现的结果
        //结果自然没有通过测试，超时了。
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int context = Math.min(height[i],height[j]) * (j - i);
                max = Math.max(context,max);
            }
        }
        return max;
    }
    public static int maxArea02(int[] height){
        //采用双指针来计算,从两侧开始移动  已知水池的容量受制于水池的长度和高度,因此当那条边短的时候移动此边即可!
        int i = 0;
        int j = height.length-1;
        int maxArea = 0;
        while (i < j){
            maxArea = Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            if (height[i] < height[j]){
                i++;
            }else {
                j--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea02(height));
    }
}
