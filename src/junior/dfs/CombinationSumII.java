package junior.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.lintcode.com/problem/153/description?fromId=161&_from=collection
 *
 * 描述
 * 给定一个数组 num 和一个整数 target. 找到 num 中所有的数字之和为 target 的组合.
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] num, int target){
        List<List<Integer>> results = new ArrayList<>();
        if (null == num || num.length == 0){
            return results;
        }
        Arrays.sort(num);
        List<Integer> subset = new ArrayList<>();
        dfs(num, 0, subset, target, results);
        return results;
    }

    private void dfs(int[] num, int startIndex, List<Integer> subset, int targetRemind, List<List<Integer>> results){
        if (targetRemind == 0){
            results.add(new ArrayList<>(subset));
            return;
        }
        if (targetRemind < 0){
            return;
        }

        for (int i = startIndex; i < num.length; i++) {
            if (i != startIndex && num[i] == num[i - 1]){
                continue;
            }
            subset.add(num[i]);
            dfs(num, i + 1, subset, targetRemind - num[i], results);
            subset.remove(subset.size() - 1);
        }
    }

}