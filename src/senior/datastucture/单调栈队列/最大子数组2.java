package senior.datastucture.单调栈队列;

import java.util.*;

/**
 * 最大子数组 II
 *
 * https://www.lintcode.com/problem/42/description?fromId=164&_from=collection
 */
public class 最大子数组2 {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(-1);
        nums.add(0);
        nums.add(1);
//        nums.add(-1);
//        nums.add(2);
//        nums.add(-1);
//        nums.add(2);
        maxTwoSubArrays(nums);
    }

    public static int maxTwoSubArrays(List<Integer> nums) {

        int len = nums.size();
        int[] left = new int[len];
        int[] right = new int[len];

        int[] leftPrefixSum = new int[len + 1];
        int[] rightPrefixSum = new int[len + 1];

        for (int i = 1; i <= len ; i++) {
           leftPrefixSum[i] = leftPrefixSum[i-1] + nums.get(i-1);
        }
        Deque<Integer> leftDeque = new ArrayDeque<>();
        int maxLeft = Integer.MIN_VALUE;
        leftDeque.offer(0);
        for (int i = 1; i < leftPrefixSum.length; i++) {
            //1.for循环外已经加了一个元素了，所以直接计算 left[i]; 用当前值 - 队列的首(最小的值) 得到 当前i的最大；
            left[i-1] = leftPrefixSum[i] - leftPrefixSum[leftDeque.peekFirst()];
            maxLeft = Math.max(left[i-1], maxLeft);//跟子数组做比较，取子数组里最大的为当前 left[i]
            left[i-1] = maxLeft;

            //2.维持队列的单调增
            while (!leftDeque.isEmpty() && leftPrefixSum[i] < leftPrefixSum[leftDeque.peekLast()]){
                leftDeque.pollLast();
            }
            //3. 上面 1. 2. 3 的顺序不能错了
            leftDeque.offerLast(i);
        }

        for (int i = len - 1; i >= 0; i--){
            rightPrefixSum[i] = rightPrefixSum[i+1] + nums.get(i);
        }
        Deque<Integer> rightDeque = new ArrayDeque<>();
        int maxRight = Integer.MIN_VALUE;
        rightDeque.offer(len);
        for (int i = len - 1; i >= 0 ; i--) {
            //1.for循环外已经加了一个元素了，所以直接计算 right[i]; 用当前值 - 队列的首(最小的值) 得到 当前i的最大；
            right[i] = rightPrefixSum[i] - rightPrefixSum[rightDeque.peekFirst()];
            maxRight = Math.max(maxRight, right[i]);//跟子数组做比较，取子数组里最大的为当前 right[i]
            right[i] = maxRight;

            //2.维持队列的单调增
            while (!rightDeque.isEmpty() && rightPrefixSum[i] < rightPrefixSum[rightDeque.peekLast()]){
                rightDeque.pollLast();
            }
            //3. 上面 1. 2. 3 的顺序不能错了,
            rightDeque.offer(i);

        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            result = Math.max(result, left[i] + right[i + 1]);
        }
        return result;
    }
}
