package junior.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/51/description
 * 描述
 * 给定一个整数数组来表示排列，按升序找出其上一个排列。
 */
public class PreviousPermutation {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        int len = nums.size();
        int i = len - 1;
        while (i > 0 && nums.get(i) >= nums.get(i - 1)){
            i--;
        }
        if (i != 0){
            int j = len - 1;
//            while (j > i && nums.get(j) <= )
        }
        return new ArrayList<>();
    }


    private static void swapItem(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private static void reverse(int[] nums, int i, int j){
        while (i < j){
            swapItem(nums, i, j);
            i++;
            j--;
        }
    }
}
