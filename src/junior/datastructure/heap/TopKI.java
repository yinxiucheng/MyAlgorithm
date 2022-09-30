package junior.datastructure.heap;

import java.util.*;

/**
 * https://www.lintcode.com/problem/545/?fromId=161&_from=collection
 * 描述
 * 实现一个数据结构，提供下面两个接口
 * 1.add(number) 添加一个元素
 * 2.topk() 返回此数据结构中最大的k个数字。当我们创建数据结构时，k是给定的。
 *
 * 数据流问题
 */
public class TopKI {

    Queue<Integer> minHeap;
    int k;

    public TopKI(int k){
        minHeap = new PriorityQueue<>();
        this.k = k;
    }

    public void add(int number){
        if (minHeap.size() < k){
            minHeap.offer(number);
        }else {
           int minValu = minHeap.peek();
           if (number > minValu){
               minHeap.poll();
               minHeap.offer(number);
           }
        }
    }

    public List<Integer> topk(){
        Iterator<Integer> iterator = minHeap.iterator();
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()){
            result.add(iterator.next());
        }
        result.sort(Collections.reverseOrder());

        return result;
    }
}
