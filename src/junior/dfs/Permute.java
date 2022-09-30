package junior.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  https://www.lintcode.com/problem/15/solution
 */
public class Permute {

    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     *          we will sort your return value in output
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
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

    private void dfs(int[] nums, boolean[] visited,List<Integer> permute, List<List<Integer>> results){
        if (permute.size() == nums.length){
            results.add(new ArrayList<>(permute));
        }

        for (int i = 0; i < nums.length ; i++) {
            if (visited[i]){
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
