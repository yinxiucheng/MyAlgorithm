package senior.presum;

/**
 * 868 · 子数组的最大平均值
 * https://www.lintcode.com/problem/868
 *
 * 描述
 * 给定一个由n个整数组成的数组，找到给定长度k的连续子数组，该子数组具有最大平均值。你需要输出最大平均值。
 *
 * 输入: nums = [1,12,-5,-6,50,3] and k = 4
 * 输出: 12.75
 * 解释:
 * 最大平均为(12-5-6+50)/4 = 51/4 = 12.75
 *
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
            if (i >= k){
                max = Math.max(max, preSum[i] - preSum[i-k]);
            }
        }
        max = max == Double.MIN_VALUE? -1: max;
        return max * 1.0/k;
    }
}
