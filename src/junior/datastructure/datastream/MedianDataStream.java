package junior.datastructure.datastream;

import java.util.*;

/**
 * https://www.lintcode.com/problem/81/description?fromId=161&_from=collection
 *
 * 描述
 * 本题将给出一个整数数据流，你将实现如下两个函数：
 *
 * 函数 add(val) ：从数据流中获得一个数字。
 * 函数 getMedian() ：返回你从数据流获得的所有数字的 中位数。
 * 本题的 中位数 不等同于数学定义里的 中位数 。
 * 本题的中位数是指将所有数字排序后得到数组的中间值，如果有数组 A 中有 n 个数，则中位数为 A[(n - 1) / 2] 。
 * 比如：数组 A=[1,2,3] 的中位数是 A[(3-1)/2] = A[1] = 2，数组 A=[1,19] 的中位数是 A[(2-1)/2] = A[0] = 1 。
 */
public class MedianDataStream {

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        MedianDataStream stream = new MedianDataStream();
        stream.add(1);
        result.add(stream.getMedian());
        stream.add(2);
        result.add(stream.getMedian());
        stream.add(3);
        result.add(stream.getMedian());
        stream.add(4);
        result.add(stream.getMedian());
        stream.add(5);
        result.add(stream.getMedian());

        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            if (i != result.size() - 1){
                System.out.print(result.get(i) + ",");
            }else {
                System.out.print(result.get(i));
            }
        }
        System.out.print("]");
    }
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianDataStream(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    /**
     * @param val: a num from the data stream.
     * @return: nothing
     */
    public void add(int val) {
        if (maxHeap.isEmpty()){
            maxHeap.offer(val);
            return;
        }
        if (val < maxHeap.peek()) {
            maxHeap.offer(val);
        } else {
            minHeap.offer(val);
        }
        changeBalance(maxHeap, minHeap);
    }

    private void changeBalance(Queue<Integer> maxHeap, Queue<Integer> minHeap){
        if (minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }else if (maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
    }

    /**
     * @return: return the median of the all numbers
     */
    public int getMedian() {
        if (maxHeap.isEmpty()){
            return 0;
        }
        return maxHeap.peek();
    }
}
