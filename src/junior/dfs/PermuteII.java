package junior.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.lintcode.com/problem/15/solution
 *
 * 使用全排列来 查找所有的 子集。
 * 找到当前 数组的下一个 排列，知道没有下一个排列位置。
 */
public class PermuteII {

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        boolean next = nextPermutation(nums);
        while (next){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            results.add(list);
            next = nextPermutation(nums);
        }
        return results;
    }

    private boolean nextPermutation(int[] nums){
        int len = nums.length;
        int i = len - 1;
        while (i > 0 && nums[i] <= nums[i - 1]){
            i--;
        }
        if (i<=0){ //没有下一个排列了。
            return false;
        }
        int j = len - 1;
        while (j >= i && nums[j] <= nums[i-1]){
            j--;
        }
        swapItem(nums, j, i-1);
        reverse(nums, i, len-1);
        return true;
    }

    private void swapItem(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j){
        while (i < j){
            swapItem(nums, i, j);
            i ++;
            j --;
        }
    }
}
