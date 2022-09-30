package junior.bfs.treetraverl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BFS 子序列
 *
 * https://www.lintcode.com/problem/17/solution/16630
 *
 */
public class SubSets {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     *          we will sort your return value in output
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> queue = new ArrayList<>();
        queue.add(new ArrayList<>());
        if (null == nums){
            return queue;
        }
        Arrays.sort(nums);
        int index = 0;
        while (index < queue.size()){
            List<Integer> subSets = queue.get(index ++);

            for (int i = 0; i < nums.length; i++) {
                if (subSets.size() != 0 && subSets.get(subSets.size() - 1) >= nums[i]){
                    continue;
                }
                List<Integer> newSubSets = new ArrayList<>(subSets);
                newSubSets.add(nums[i]);
                queue.add(newSubSets);
            }
        }
        return queue;
    }
}
