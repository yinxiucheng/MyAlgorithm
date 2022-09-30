package junior.dpmemo;

import java.util.HashMap;
import java.util.Objects;

/**
 * 398 · 最长上升连续子序列 II
 *
 * https://www.lintcode.com/problem/398/
 *
 * 描述
 * 给定一个整数矩阵. 找出矩阵中的最长连续上升子序列, 返回它的长度.
 *
 * 最长连续上升子序列可以从任意位置开始, 向上/下/左/右移动.
 *
 */
public class LISII {

    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */
    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        HashMap<Point, Integer> memo = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Point point = new Point(i, j, matrix[i][j]);
                maxLength = Math.max(maxLength, dfs(point, matrix, memo));
            }
        }
        return maxLength;
    }

    private final int[][] DIRECTIONS = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    private int dfs(Point point, int[][] matrix, HashMap<Point, Integer> memo){
        //递归的出口， 包含时就直接返回。
        if (memo.containsKey(point)){
            return memo.get(point);
        }
        int maxLength = 1; // 从1 开始，从自己开始算。
        for (int i = 0; i < DIRECTIONS.length ; i++) {
            int x = point.x + DIRECTIONS[i][0];
            int y = point.y + DIRECTIONS[i][1];
            if (!isInBoard(x, y, matrix)){
                continue;
            }
            Point neighbor = new Point(x, y, matrix[x][y]);
            if (point.val >= neighbor.val){ // 注意这里 是 >=, 不是 大于， 严格递增。
                continue;
            }
            int length = dfs(neighbor, matrix, memo);
            maxLength = Math.max(length + 1, maxLength);// 从四条路径里打擂台。
        }
        memo.put(point, maxLength);
        return maxLength;
    }

    private boolean isInBoard(int x, int y, int[][] matrix){
        //边界判断，x、y 坐标的上下边界。
        return x>= 0 &&  x < matrix.length && y >= 0 && y < matrix[0].length;
    }

    class Point {
        int x, y;
        int val;
        public Point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && val == point.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, val);
        }
    }
}
