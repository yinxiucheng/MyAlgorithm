package junior.datastructure.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/486/?fromId=161&_from=collection
 *
 * 描述
 * 将 k 个有序数组合并为一个大的有序数组。
 */
public class MergekSortedArrays {

    public static void main(String[] args) {
        int[][] arrays = new int[][]{
                {1,3,5,7},
                {2,4,6},
                {0,8,9,10,11}
        };
        int[] result = mergekSortedArrays(arrays);
    }
    public static int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        List<List<Integer>> temp = new ArrayList<>();
        Queue<Integer> maxHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        int k = arrays.length;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < arrays[i].length; j++) {
                list.add(arrays[i][j]);
            }
            temp.add(list);
        }

        while (!temp.isEmpty()){
            for (int i = 0; i < temp.size(); i++) {
                List<Integer> list = temp.get(i);
                if (list.size() > 0){
                    int value = list.get(0);
                    if (maxHeap.size() < k) {
                        maxHeap.offer(value);
                        maxValue = Math.max(value, maxValue);
                        list.remove(0);
                    } else  {
                        result.add(maxHeap.poll());
                        maxHeap.offer(value);
                        list.remove(0);
                    }
                }else {
                    temp.remove(list);
                }
            }
        }
        while (!maxHeap.isEmpty()){
            result.add(maxHeap.poll());
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
