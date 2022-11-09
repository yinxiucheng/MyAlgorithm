package onehundred;

import java.util.*;

/**
 * 排序矩阵中的从小到大第k个数
 *
 *
 */
public class 排序矩阵中的从小到大第k个数 {

    int[][] DIRECTION = {{1,0}, {0, 1}};

    public int kthSmallest(int[][] matrix, int k) {
        if (null == matrix || matrix.length == 0){
            return 0;
        }

        //用 优先队列进行 BFS。
        Queue<Element> queue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

        Set<Integer> visited = new HashSet<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int index = 0 * m + 0;
        Element first = new Element(index, matrix[0][0]);
        queue.offer(first);
        visited.add(index);

        int count = 1;
        while (!queue.isEmpty()){
            Element curElement = queue.poll();
            int curIndex = curElement.index;
            int x = curIndex / m;
            int y = curIndex % m;
            if (count == k){
                return matrix[x][y];
            }
            for (int[] direction: DIRECTION) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m){
                    int newIndex = newX * m  + newY;
                    if (visited.contains(newIndex)){
                        continue;
                    }
                    Element newElement = new Element(newIndex, matrix[newX][newY]);
                    queue.offer(newElement);
                    visited.add(newIndex);
                }
            }
            count ++;
        }

        return -1;
    }

    class Element{
        int index;
        int value;
        public Element(int index, int value){
            this.index = index;
            this.value = value;
        }
    }


}
