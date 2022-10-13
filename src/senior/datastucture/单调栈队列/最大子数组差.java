package senior.datastucture.单调栈队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 45 · 最大子数组差
 *
 * https://www.lintcode.com/problem/45/?fromId=164&_from=collection
 *
 * 描述
 * 给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组和的差的绝对值|SUM(A) - SUM(B)|∣SUM(A)−SUM(B)∣最大。返回这个最大的差值。
 *
 */
public class 最大子数组差 {
    public static void main(String[] args) {
        int[] nums = {1,2,-3,1};
        maxDiffSubArrays(nums);
    }

    public static int maxDiffSubArrays(int[] nums) {
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] leftMin = new int[len];
        int[] rightMax = new int[len];
        int[] rightMin = new int[len];

        int[] prefixLeftSum = new int[len + 1];
        int[] prefixRightSum = new int[len + 1];

        for (int i = 1 ; i <= len; i++) {
            prefixLeftSum[i] = prefixLeftSum[i-1] + nums[i-1];
        }
        for (int i = len - 1; i >= 0; i --){
            prefixRightSum[i] = prefixRightSum[i+1] + nums[i];
        }

        // 借助单调队列 分别求出 左右，最大、最小的子数组和
        computeLeftMax(prefixLeftSum, leftMax);
        computeLeftMin(prefixLeftSum, leftMin);
        computeRightMax(prefixRightSum, rightMax);
        computeRightMin(prefixRightSum, rightMin);

        //最后遍历 用每个 坐标对应的 leftMax - rightMin 跟 rightMax - leftMin 打擂台，求最大值。
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(leftMax[i] - rightMin[i+1]));
            maxDiff = Math.max(maxDiff, Math.abs(leftMin[i] - rightMax[i+1]));
        }
        return maxDiff;
    }

    //计算左边最小子数组和
    private static void computeLeftMin(int[] prefixLeftSum, int[] leftMin){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        int len = leftMin.length;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            leftMin[i-1] = prefixLeftSum[i] - prefixLeftSum[deque.peekFirst()];
            min = Math.min(min, leftMin[i-1]);
            leftMin[i-1] = min;
            while (!deque.isEmpty() && prefixLeftSum[i] > prefixLeftSum[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
    }

    //计算右边最小子数组和
    private static void computeRightMin(int[] prefixRightSum, int[] rightMin){
        Deque<Integer> deque = new ArrayDeque<>();
        int len = rightMin.length;
        int min = Integer.MAX_VALUE;
        deque.offer(len);
        for (int i = len - 1; i >= 0; i--) {
            rightMin[i] = prefixRightSum[i] - prefixRightSum[deque.peekFirst()];
            min = Math.min(min, rightMin[i]);
            rightMin[i] = min;

            while (!deque.isEmpty() && prefixRightSum[i] > prefixRightSum[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
    }

    //计算左边 最大子数组和。
    private static void computeLeftMax(int[] prefixLeftSum, int[] leftMax){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        int len = leftMax.length;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= len ; i++) {
            leftMax[i-1] = prefixLeftSum[i] - prefixLeftSum[deque.peekFirst()];
            max = Math.max(max, leftMax[i-1]);
            leftMax[i-1] = max;
            while (!deque.isEmpty() && prefixLeftSum[i] < prefixLeftSum[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
    }

    //计算右边 最大子数组和
    private static void computeRightMax(int[] prefixRightSum, int[] rightMax){
        Deque<Integer> deque = new ArrayDeque<>();
        int len = rightMax.length;
        deque.offer(len);
        int max = Integer.MIN_VALUE;
        for (int i = len -1; i >= 0 ; i--) {
            rightMax[i] = prefixRightSum[i] - prefixRightSum[deque.peekFirst()];
            max = Math.max(max, rightMax[i]);
            rightMax[i] = max;
            while (!deque.isEmpty() && prefixRightSum[i] < prefixRightSum[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
    }
}
