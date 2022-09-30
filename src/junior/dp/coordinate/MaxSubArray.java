package junior.dp.coordinate;

/**
 * 41 · 最大子数组
 *
 * https://www.lintcode.com/problem/41/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 * 每个子数组的数字在数组中的位置应该是连续的。
 */
public class MaxSubArray {

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int m = preSum.length;
        int max = Integer.MIN_VALUE;
        for (int len = 1; len <= m ; len++) {
            for (int i = 1; i < m - len + 1; i++) {//注意边界条件，利用前缀和数组计算 区间和的时候，不会越界。
                int j = i + len - 1;
                int sum = preSum[j] - preSum[i-1];//这里跟上面的 for循环条件匹配。保证不越界。
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
