package junior.twopointer.towsum;

import java.util.Arrays;

/**
 * 533 · 两数和的最接近值
 *
 * 描述
 * 给定整数数组num，从中找到两个数字使得他们和最接近target，返回两数和与 target 的差的 绝对值。
 *
 *
 */
public class TwoSumClosest {

    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        if (null == nums || nums.length < 2){
            return Integer.MAX_VALUE;
        }

        Arrays.sort(nums);
        int start = 0 ;
        int end = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (start < end){
            int sum = nums[start] + nums[end];
            if (sum < target){
                diff = Math.min(diff, target - sum);
                start ++ ;
            }else if (sum > target){
                diff = Math.min(diff, sum - target);
                end --;
            }else {
                return 0;
            }
        }
        return diff;
    }
}
