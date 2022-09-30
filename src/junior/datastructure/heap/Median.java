package junior.datastructure.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 80. 中位数
 * https://www.lintcode.com/problem/80/description
 *
 * 描述
 * 给定一个未排序的整数数组，找到其中位数。中位数是升序排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数。
 */
public class Median {

    public int median(int[] nums) {
        int K = (nums.length + 1) / 2;
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (heap.size() == K){
                if (item < heap.peek()){//找第K大的数。
                    heap.poll();
                    heap.offer(item);
                }
            }else {
                heap.offer(item);
            }
        }
        return heap.peek();
    }
}
