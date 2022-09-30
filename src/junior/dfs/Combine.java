package junior.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/152/?fromId=161&_from=collection
 *
 * 描述
 * 给定两个整数 n 和 k. 返回从 1, 2, ... , n 中选出 k 个数的所有可能的组合.
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> results = new ArrayList<>();

//        int[] nums = createNums(n);
        List<Integer> subset = new ArrayList<>();
        dfs( n,1, subset, k, results);
        return results;
    }

    private void dfs(int n,  int startIndex, List<Integer> subset, int k, List<List<Integer>> results){
        if (subset.size() == k){
            results.add(new ArrayList<>(subset));
            return;
        }
        if( (subset.size() + n - startIndex )< k){
            return;
        }
        for (int i = startIndex; i < n; i++) {
            subset.add(i);
            dfs(n, i+1, subset, k, results);
            subset.remove(subset.size() - 1);
        }
    }

    private int[] createNums(int n){
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}
