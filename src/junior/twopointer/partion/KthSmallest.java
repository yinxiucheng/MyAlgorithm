package junior.twopointer.partion;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 461 · 无序数组K小元素
 *
 * 描述
 * 找到一个无序数组中第 K 小的数（K 从1开始）。
 *
 */
public class KthSmallest {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if (null == nums || nums.length < k){
            return -1;
        }

        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < k ; i++) {
            ans = heap.poll();
        }

        return ans;
    }
}
