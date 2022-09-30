package junior.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.lintcode.com/problem/90/?fromId=161&_from=collection
 *
 * 描述
 * 给定 n 个不同的正整数，整数 k（1<=k<=n1<=k<=n）以及一个目标数字。
 *
 * 在这 n 个数里面找出 k 个不同的数，使得这 k 个数的和等于目标数字，你需要找出所有满足要求的方案（方案顺序不作要求）。
 */
public class KSumII {

    /**
     * @param a: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     *          we will sort your return value in output
     */
    public List<List<Integer>> kSumII(int[] a, int k, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == a || a.length == 0){
            return results;
        }
        Arrays.sort(a);
        dfs(a, 0, new ArrayList<>(), k, target, results);
        return results;
    }

    private void dfs(int[] nums, int startIndex, List<Integer> subSet, int k, int targetRemind, List<List<Integer>> results){
        if (subSet.size() == k && targetRemind == 0){
            results.add(new ArrayList<>(subSet));
            return;
        }
        if (subSet.size() > k || targetRemind < 0){
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            subSet.add(nums[i]);
            dfs(nums, i + 1, subSet, k, targetRemind - nums[i], results);
            subSet.remove(subSet.size() - 1);
        }
    }
}
