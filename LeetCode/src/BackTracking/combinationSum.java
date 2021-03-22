package BackTracking;

import java.util.LinkedList;
import java.util.List;

public class combinationSum {
    //组合总合
    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //
    //candidates 中的数字可以无限制重复被选取。
    /*
    输入：candidates = [2,3,6,7], target = 7,
    所求解集为：
    [
      [7],
      [2,2,3]
    ]
     */

    /*
       题解思路:
       本题采用回溯法,因为要涉及多种不同的可能,模型就可以看做是一个二叉树,分支就是向 1.第i位 2.第i+1位
     */
    public static void main(String[] args) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        int[] arr = {2,3,6,7};
        int target = 7;
        dsf(arr,target,0,list,ans);

        System.out.println(ans);
    }

    private static void dsf(int[] candidates,int target,int index,List<Integer> list,LinkedList<List<Integer>> ans) {
        if (index == candidates.length){
            return;
        }
        if (target == 0){
            ans.add(new LinkedList<>(list));
            return;
        }
        dsf(candidates, target, index+1, list, ans);

        if (target - candidates[index] >= 0){
            list.add(candidates[index]);
            dsf(candidates, target-candidates[index], index, list, ans);
            list.remove(list.size()-1);
        }
    }
}
