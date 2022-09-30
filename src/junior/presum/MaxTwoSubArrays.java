package junior.presum;

import java.util.List;

/**
 * 42 · 最大子数组 II
 *
 * https://www.lintcode.com/problem/42/description
 * 描述
 * 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
 * 每个子数组的数字在数组中的位置应该是连续的。
 * 返回最大的和。
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 *
 * nums = [1, 3, -1, 2, -1, 2]
 * 输出：
 *
 * 7
 * 解释：
 *
 * 最大的子数组为 [1, 3] 和 [2, -1, 2] 或者 [1, 3, -1, 2] 和 [2].
 *
 */
public class MaxTwoSubArrays {

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     *
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        int n = nums.size();
        int[] preSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums.get(i-1);
        }

        int[] leftSum = new int[n];
        for (int i = 0; i < n; i++) {
            leftSum[i] = preSum[i+1];
        }

        int[] rightSum = new int[n];
        for (int i = 0; i < n ; i++) {
            rightSum[i] = preSum[n] - preSum[i];
        }

        int result = 0;
        for (int i = 0; i < n-1; i++) {
            result = Math.max(result, leftSum[i] + rightSum[i+1]);
        }
        return result;
    }
}
