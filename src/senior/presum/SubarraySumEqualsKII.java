package senior.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * 1844 · 子数组和为K II
 *
 * https://www.lintcode.com/problem/1844/?fromId=178&_from=collection
 *
 *
 * 描述
 * 给定一个整数数组和一个整数k，你需要找到和为k的最短非空子数组，并返回它的长度。
 *
 * 如果没有这样的子数组，返回-1.
 *
 * 输入:
 * nums = [2,1,-1,4,2,-3] and k = 3
 * 输出:
 * 2
 *
 */
public class SubarraySumEqualsKII {

    public int subarraySumEqualsKII(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, 0);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
            int needFind = preSum[i] - k;
            if (sumToIndex.containsKey(needFind)){
                min = Math.min(min, i - sumToIndex.get(needFind));
            }
            sumToIndex.put(preSum[i], i);
        }

        return min == Integer.MAX_VALUE? -1 : min;
    }
}
