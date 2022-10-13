package senior.datastucture.单调栈队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 620 · 最大子数组 IV
 *
 * https://www.lintcode.com/problem/620
 *
 * 描述
 * 给定一个整数数组，找到长度大于或等于 k 的连续子序列使它们的和最大，返回这个最大的和，如果数组中少于k个元素则返回 0
 *
 */
public class 最大子数组4 {

    public int maxSubarray4(int[] nums, int k) {
        //单调队列 一遍过。
        if (null == nums || nums.length == 0 || nums.length < k){
            return 0;
        }
        int len = nums.length;
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {

            if (i >= k){
                while (!deque.isEmpty() && prefixSum[i - k] < prefixSum[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.offerLast(i - k);
            }

            if (!deque.isEmpty()){
                max = Math.max(max, prefixSum[i] - prefixSum[deque.peekFirst()]);
            }
//            if (i - deque.peekFirst() > k){
//                deque.pollFirst();
//            }
        }
        return max;
    }
}
