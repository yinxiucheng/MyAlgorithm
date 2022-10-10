package senior.datastucture.单调栈队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 1507 · 和至少为 K 的最短子数组
 * https://www.lintcode.com/problem/1507/?fromId=178&_from=collection
 *
 */
public class 和至少为K的最短子数组 {

    public int shortestSubarray(int[] A, int k) {
        int[] prefix = new int[A.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + A[i-1];
        }
        int len = prefix.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int cur = prefix[i];
            while (!deque.isEmpty() && cur - prefix[deque.peekFirst()] >= k){
                minLen = Math.min(minLen, i - deque.peekFirst());
                deque.pollFirst();
            }
            while (!deque.isEmpty() && prefix[deque.peekLast()] >= cur){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        if (minLen == Integer.MAX_VALUE){
            return -1;
        }
        return minLen;
    }

}
