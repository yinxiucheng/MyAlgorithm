package senior.presum;

import java.util.*;

/**
 *  1507 · 和至少为 K 的最短子数组
 *
 *  https://www.lintcode.com/problem/1507/note?fromId=178&_from=collection
 *
 *
 */
public class ShortestSubarray {

    public int shortestSubarray(int[] a, int k) {
        int[] preSum = getPreSum(a);
        int start = 1, end = a.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isValid(preSum, k, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isValid(preSum, k, start)) {
            return start;
        }
        if (isValid(preSum, k, end)) {
            return end;
        }
        return -1;
    }

    private boolean isValid(int[] preSum, int K, int length){
        Heap minHeap = new Heap();
        for (int end = 0; end < preSum.length; end++) {
            int index = end - length - 1;
            if (index >= 0 && index < preSum.length){
                minHeap.delete(index);
            }
            if (!minHeap.isEmpty() && preSum[end] - minHeap.top().val >= K ){
                return true;
            }
            minHeap.push(end, preSum[end]);
        }
        return false;
    }

    private int[] getPreSum(int[] A){
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        return preSum;
    }

    class Heap{
        Queue<ValueIndexPair> minHeap;
        HashSet<Integer> deleteSet;

        Heap(){
            minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            deleteSet = new HashSet<>();
        }

        public void push(int index, int val){
            lazyDelete();
            minHeap.offer(new ValueIndexPair(index, val));
        }

        public void delete(int index){
            deleteSet.add(index);
        }

        public ValueIndexPair top(){
            lazyDelete();
            return minHeap.peek();
        }

        public void lazyDelete(){
            while (!isEmpty() && deleteSet.contains(minHeap.peek().index) ){
               ValueIndexPair pair =  minHeap.poll();
               deleteSet.remove(pair.index);
            }
        }

        public boolean isEmpty(){
            return minHeap.isEmpty();
        }
    }

    class ValueIndexPair {
        int index;
        int val;
        ValueIndexPair(int index, int val){
            this.index = index;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ValueIndexPair pair = (ValueIndexPair) o;
            return index == pair.index && val == pair.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, val);
        }
    }
}
