package junior.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.lintcode.com/problem/135/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个候选数字的集合 candidates 和一个目标值 target。 找到 candidates 中所有的和为 target 的组合。
 *
 * 在同一个组合中, candidates 中的某个数字出现次数不限。
 */
public class CombinationSum {

    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     *          we will sort your return value in output
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == candidates || candidates.length == 0){
            return results;
        }
        int[] nums = removeDuplicates(candidates);
        dfs(nums, 0, new ArrayList<>(), target, results);
        return results;
    }

    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);

        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }

        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }

        return nums;
    }

    private void dfs(int[] candidates, int startIndex,List<Integer> subSet, int targetRemind, List<List<Integer>> results){
        if(targetRemind == 0){
            results.add(new ArrayList<>(subSet));
            return;
        }
        if (targetRemind < 0){
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            subSet.add(candidates[i]);
            dfs(candidates, i, subSet, targetRemind - candidates[i], results);
            subSet.remove(subSet.size() - 1);
        }
    }
}
