package junior.dp.coordinate;

import junior.datamodel.Point;

import java.util.*;

/**
 * 679 · 不同的路径 III
 *
 * https://www.lintcode.com/problem/679
 *
 * 描述
 * "Unique Paths II"的后续。
 *
 * 在这题里，我们会给你一个有权值的地图，你需要找到所有权值不同的路径之和。
 *
 */
public class UniquePathsIII {

    public static void main(String[] args) {
//        int[][] grid = {
//                {1,1,2},
//                {1,2,3},
//                {3,2,4}
//        };

        int[][] grid = {
                {1,9,5,1,3,7,1,8,9}
        };

      int result =  uniqueWeightedPaths(grid);
      System.out.print("the result is "+ result);

    }
    /**
     * @param grid: an array of arrays
     * @return: the sum of all unique weighted paths
     */
    public static int uniqueWeightedPaths(int[][] grid) {
        if (null == grid || grid.length == 0){
            return 0;
        }
        if (null == grid[0] || grid[0].length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        //# state dp 表示 抵达(i, j)点的权值不同的路径和。
        int[][] dp = new int[n][m];
        Map<Point, Set<Integer>> map = new HashMap<>();
        dp[0][0] = grid[0][0];
        putInMap(0,0, dp[0][0], map);

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
            putInMap(i,0, dp[i][0], map);
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
            putInMap(0, j, dp[0][j], map);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m ; j++) {
                Point preLeft = new Point(i-1, j);
                Point preTop = new Point(i, j- 1);
                Set<Integer> set = new HashSet<>();
                setEachAdd(set, map.get(preLeft), grid[i][j]);
                setEachAdd(set, map.get(preTop), grid[i][j]);
                Point current = new Point(i, j);
                map.put(current, set);
            }
        }

       Set<Integer> ansSet = map.get(new Point(n-1, m-1));
        int ans = 0;
        for (Integer integer: ansSet) {
            ans += integer;
        }
        return ans;
    }

    private static void setEachAdd(Set<Integer> set, Set<Integer> target, int value){
        for (Integer item: target) {
            set.add(item + value);
        }
    }

    private static void putInMap(int i, int j, int value, Map<Point, Set<Integer>> map){
        Point point = new Point(i, j);
        if (!map.containsKey(point)){
            Set<Integer> set = new HashSet<>();
            set.add(value);
            map.put(point, set);
        }else {
            map.get(point).add(value);
        }
    }

}
