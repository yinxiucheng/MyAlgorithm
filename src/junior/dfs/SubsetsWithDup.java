package junior.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集。
 *
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        if (null == nums){
            return results;
        }
        if (nums.length == 0){
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }

    private void dfs(int[] nums, int startIndex, List<Integer> subSet, List<List<Integer>> results){
        results.add(new ArrayList<>(subSet));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]){ //同一层
                continue;
            }
            subSet.add(nums[i]);
            dfs(nums, i + 1, subSet, results);
            subSet.remove(subSet.size() - 1);
        }

    }
}
