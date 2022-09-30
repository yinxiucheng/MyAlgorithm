package junior.datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/486/?fromId=161&_from=collection
 *
 * 描述
 * 将 k 个有序数组合并为一个大的有序数组。
 */
public class MergeSortedArraysI {

    public int[] mergekSortedArrays(int[][] arrays) {
        Comparator<Element> comparator = Comparator.comparingInt(left -> left.val);

        int k = arrays.length;
        Queue<Element> heap = new PriorityQueue<>(k, comparator);
        int totalSize = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0){
                heap.add(new Element(i, 0, arrays[i][0]));
            }
            totalSize += arrays[i].length;
        }
        int[] result = new int[totalSize];
        int count = 0;
        while (!heap.isEmpty()){
            Element ele = heap.poll();
            result[count++] = ele.val;
            if (ele.col + 1 < arrays[ele.row].length){
                ele.col = ele.col + 1;
                ele.val = arrays[ele.row][ele.col];
                heap.add(ele);
            }
        }
        return result;
    }

    public class Element{
        public int row;
        public int col;
        public int val;

        public Element(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
