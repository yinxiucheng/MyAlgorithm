package senior.datastucture.单调栈队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 621 · 最大子数组 V
 *
 * https://www.lintcode.com/problem/621/solution/25281?showListFe=true&page=1&problemTypeId=2&tagIds=359&pageSize=50
 *
 *描述
 * 给定一个整数数组，找到长度在 k1 与 k2 之间(包括 k1, k2)的子数组并且使它们的和最大，返回这个最大值，如果数组元素个数小于 k1 则返回 0
 */
public class 最大子数组5 {

    public static void main(String[] args) {
        int[] nums = {5};
        maxSubarray5(nums, 1, 4);
    }

    public static int maxSubarray5(int[] nums, int k1, int k2) {
        if (null == nums || nums.length == 0 || nums.length < k1){
            return 0;
        }
        int len = nums.length;
        int[] prefixSum = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }

        int result = Integer.MIN_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= len ; i++) {
            //维持窗口大小 【k1, k2]
            while (!deque.isEmpty() && i - k2 > deque.peekFirst()){
                deque.pollFirst();
            }

            if (i >= k1){
                //保持 deque 单调增。
                while (!deque.isEmpty() && prefixSum[i-k1] < prefixSum[deque.peekLast()]){
                    deque.pollLast();
                }
                //todo 注意这里offer的不是 i,而是 i-k1;
                deque.offerLast(i - k1);
            }

            // todo deque 中 【i-k2, i - k1]
            if (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] > result){
                result = Math.max(result, prefixSum[i] - prefixSum[deque.peekFirst()]);
            }
        }
        return result;
    }
}
