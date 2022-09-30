package junior.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  https://www.lintcode.com/problem/16/
 *
 *  描述
 *  给出一个具有重复数字的列表，找出列表所有不同的排列。
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        if (null == nums){
            return results;
        }
        if (nums.length == 0){
            results.add(new ArrayList<>());
            return results;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> permute = new ArrayList<>();
        dfs(nums, visited, permute, results);
        return results;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> permute, List<List<Integer>> results){
        if (permute.size() == nums.length){
            results.add(new ArrayList<>(permute));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){ //去除重复。
                continue;
            }
            permute.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permute, results);
            visited[i] = false;
            permute.remove(permute.size() - 1);
        }
    }
}
