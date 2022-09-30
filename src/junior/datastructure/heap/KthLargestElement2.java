package junior.datastructure.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/606/?fromId=161&_from=collection
 *
 * 描述
 * 找到数组中第K大的元素，N远大于K。请注意你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 */
public class KthLargestElement2 {

    /**
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < k){
                heap.offer(nums[i]);
            }else{
                if (nums[i] > heap.peek()){
                    heap.poll();
                    heap.offer(nums[i]);
                }else {
                    continue;
                }
            }

        }
        return heap.poll();
    }
}
