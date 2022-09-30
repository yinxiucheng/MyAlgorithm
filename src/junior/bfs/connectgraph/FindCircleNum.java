package junior.bfs.connectgraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 1179 · 朋友圈
 * https://www.lintcode.com/problem/1179/?fromId=161&_from=collection
 * <p>
 * 描述
 * 一个班中有N 个学生。他们中的一些是朋友，一些不是。他们的关系传递。例如，如果A是B的一个直接朋友，而B是C的一个直接朋友，那么A是C的一个间接朋友。我们定义朋友圈为一组直接和间接朋友。
 * 给出一个N*N 矩阵M表示一个班中学生的关系。如果m〔i〕〔J〕＝1，那么第i个学生和第j个学生是直接朋友，否则不是。你要输出朋友圈的数量。
 * <p>
 * 找联通图问题。
 */
public class FindCircleNum {
    /**
     * @param grid: a matrix
     * @return: the total number of friend circles among all the students
     */
    public int findCircleNum(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] == 1){//表示未访问
                bfs(grid, i);
                count ++;
            }
        }
        return count;
    }

    private void bfs(int[][] grid, int student) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(student);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int k = queue.poll();
                grid[k][k] = 2;//表示访问过了
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[k][j] == 1 && grid[j][j] == 1){
                        queue.offer(j);
                    }
                }
            }
        }
    }
}
