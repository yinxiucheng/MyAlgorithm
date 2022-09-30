package junior.twopointer.towsum;

import java.util.Arrays;

/**
 * 443 · 两数之和 II
 *
 * 描述
 * 给一组整数，问能找出多少对整数，他们的和大于一个给定的目标值。请返回答案。
 *
 * 样例
 * 样例 1:
 *
 * 输入: [2, 7, 11, 15], target = 24
 * 输出: 1
 * 解释: 11 + 15 是唯一的一对
 */
public class TwoSum2 {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        if (null == nums || nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int ans = 0;
        while (start < end){
            int sum = nums[start] + nums[end];
            if (sum <= target){
                start ++ ;
            }else{// TODO 注意批量计算。
                ans += end - start;
                end --;
            }
        }
        return ans;
    }
}
