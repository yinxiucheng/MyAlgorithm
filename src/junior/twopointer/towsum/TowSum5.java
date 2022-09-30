package junior.twopointer.towsum;

import java.util.Arrays;

/**
 * 描述
 * 给定一个整数数组，找出这个数组中有多少个不同的下标对，满足下标对中的两个下标所对应元素之和小于或等于目标值。返回下标对数。
 */
public class TowSum5 {

    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        if (null == nums || nums.length < 2) return 0;

        Arrays.sort(nums);

        int count = 0;
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            int start = i;
            int end = len - 1;

            //找到 nums[i] + nums[index] <= target  index 最大坐标。
            int index = -1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[i] + nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (nums[end] + nums[i] <= target) {
                index = end;
            } else if (nums[start] + nums[i] <= target) {
                index = start;
            }
            if (index != -1) count += index - i;
        }
        return count;
    }
}
