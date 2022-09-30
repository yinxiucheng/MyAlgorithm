package junior.twopointer.towsum;

/**
 * 610 · 两数和 - 差等于目标值
 *
 * https://www.lintcode.com/problem/610/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个排序后的整数数组，找到两个数的 差 等于目标值。
 * 你需要返回一个包含两个数字的列表 [num1, num2], 使得 num1 与 num2 的差为 target，同时 num1 必须小于 num2。
 *
 */
public class TwoSum7 {

    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        if (null == nums || nums.length <= 1){
            return new int[] {-1, -1};
        }

        target = Math.abs(target);
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            j = Math.max(j, i + 1);
            while (j < nums.length && nums[j] - nums[i] < target){
                j ++;
            }
            if (nums[j] - nums[i] == target){
                return new int[]{nums[i], nums[j]};
            }
        }

        return new int[]{-1, -1};
    }
}
