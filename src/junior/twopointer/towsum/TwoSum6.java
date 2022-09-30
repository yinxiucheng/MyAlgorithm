package junior.twopointer.towsum;

import java.util.Arrays;

/**
 * 587 · 两数之和 - 不同组成
 *
 * 描述
 * 给一整数数组, 找到数组中有多少组 不同的元素对 有相同的和, 且和为给出的 target 值, 返回对数.
 *
 * 输入: nums = [1,1,2,45,46,46], target = 47
 * 输出: 2
 * 解释:
 *
 * 1 + 46 = 47
 * 2 + 45 = 47
 */
public class TwoSum6 {

    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        if (null == nums || nums.length < 2){
            return 0;
        }

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end){
            if (nums[start] + nums[end] < target){
                start ++;
            }else if (nums[start] + nums[end] > target){
                end --;
            }else {
                count ++ ;
                start ++;
                end --;
                while (start < end && nums[start] == nums[start -1]){
                    start ++;
                }
                while (start < end && nums[end] == nums[end + 1]){
                    end --;
                }
            }
        }
        return count;
    }
}
