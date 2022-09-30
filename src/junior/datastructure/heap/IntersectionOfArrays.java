package junior.datastructure.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/793/description?fromId=161&_from=collection
 *
 * 描述
 * 给出多个数组，求它们的交集。输出他们交集的大小。
 *
 * 输入:  [[1,2,3],[3,4,5],[3,9,10]]
 * 输出:  1
 *
 * 解释:
 * 只有 3 出现在三个数组中。
 *
 *
 * 输入: [[1,2,3,4],[1,2,5,6,7],[9,10,1,5,2,3]]
 * 输出:  2
 *
 * 解释:
 * 交集是 [1,2]。
 *
 *
 */
public class IntersectionOfArrays {

    public static void main(String[] args) {

    }
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     *
     */
    public int intersectionOfArrays(int[][] arrs) {
        Comparator<Element> comparator = new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {//小顶堆， 从小到大排列。
                int diff = e1.val - e2.val;
                return diff;
            }
        };

        int k = arrs.length;
        Queue<Element> heap = new PriorityQueue<>(k, comparator);
        for (int i = 0; i <arrs.length ; i++) {
            if (arrs[i].length == 0){
                return 0;
            }
            Arrays.sort(arrs[i]);
            heap.offer(new Element(i, 0, arrs[i][0]));
        }

        Element lastElement = null;
        int intersection = 0;
        int count = 0;
        while (!heap.isEmpty()){
            Element element = heap.poll();
            if (lastElement == null || lastElement.val != element.val){
                lastElement = element;
                if (count == k){
                    intersection++;
                }
                count = 1;
            }else{
                count ++;
            }
            element.col ++ ;
            if (element.col < arrs[element.row].length){
                heap.offer(new Element(element.row, element.col, arrs[element.row][element.col]));
            }
        }
        if (count == k){
            intersection ++;
        }
        return intersection;
    }

    class Element{
        int row, col, val;
        public Element(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
