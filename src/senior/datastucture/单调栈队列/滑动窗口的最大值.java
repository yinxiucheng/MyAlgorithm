package senior.datastucture.单调栈队列;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 362 · 滑动窗口的最大值
 * https://www.lintcode.com/problem/362/?fromId=178&_from=collection
 *
 */
public class 滑动窗口的最大值 {

    public static void main(String[] args) {
       int[] test =  {1,2,7,7,2};
       List<Integer> result = maxSlidingWindow(test, 1);

    }
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        LazyHeap lazyHeap = new LazyHeap();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (i - k >= 0 && lazyHeap.size() >= k){
                lazyHeap.delete(i - k, nums[i-k]);
            }
            lazyHeap.offer(i, nums[i]);
            if (lazyHeap.size() >= k){
                Pair pair = lazyHeap.peek();
                result.add(pair.val);
            }
        }
        return result;
    }
}
