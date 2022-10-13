package senior.datastucture.单调栈队列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * 362 · 滑动窗口的最大值
 * https://www.lintcode.com/problem/362/?fromId=178&_from=collection
 *
 */
public class 滑动窗口的最大值2 {


    public  List<Integer> maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            // 维持 单调性
           while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
               deque.pollLast();
           }
            deque.offerLast(i);
            if (i >= k - 1 ){// 当长度== k 时，加入deque的 顶部点到 result中
                result.add(nums[deque.peekFirst()]);//维持了单调性，所以第一个点必定最大。
            }
            if (i - k + 1 == deque.peekFirst()){
                deque.pollFirst();
            }
        }
        return result;
    }
}
