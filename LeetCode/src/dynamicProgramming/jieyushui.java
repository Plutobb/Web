package dynamicProgramming;

public class jieyushui {

    public static int trap(int[] height) {
        int n = height.length;
        if (n < 3){
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-1-1; i >= 0; i--) {
            rightMax[i] =  Math.max(rightMax[i+1],height[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};

        System.out.println(trap(height));

    }
}
