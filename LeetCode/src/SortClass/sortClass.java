package SortClass;

import java.util.Arrays;

public class sortClass {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=0,n=0,i=0;
        int totalLength = nums1.length+nums2.length;
        int[] ans =new  int[totalLength];
        if (nums1.length == 0 || nums2.length == 0) {
            if (nums1.length == 0) {
                ans = nums2;
            }
            if (nums2.length == 0) {
                ans = nums1;
            }
        }else {
            while (m + n <= totalLength) {
                if (nums1[m] <= nums2[n]) {
                    ans[i++] = nums1[m];
                    m++;
                } else {
                    ans[i++] = nums2[n];
                    n++;
                }
                if (m >= nums1.length) {
                    while (n < nums2.length) {
                        ans[i++] = nums2[n];
                        n++;
                    }
                    break;
                }
                if (n >= nums2.length) {
                    while (m < nums1.length) {
                        ans[i++] = nums1[m];
                        m++;
                    }
                    break;
                }
            }
        }
        if (totalLength % 2 == 0){
            return (double) (ans[totalLength/2] + ans[totalLength/2 - 1])/2;
        }else {
            return (double) ans[totalLength/2];
        }
    }

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
