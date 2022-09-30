package junior.dpmemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 109 · 数字三角形 (记忆化搜索)
 *
 * https://www.lintcode.com/problem/109/
 *
 * 描述
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 */
public class MinimumTotal {

    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
       return divideConquer(0, 0, triangle, new HashMap<Integer, Integer>());
    }

    public int divideConquer(int x, int y, int[][] triangle, Map<Integer, Integer> memo){
        if (x == triangle.length){
            return 0;
        }
        int hashCode = x * triangle.length + y;
        if (memo.containsKey(hashCode)){
            return memo.get(hashCode);
        }
        int left = divideConquer(x + 1, y, triangle, memo);
        int right = divideConquer(x + 1, y + 1, triangle, memo);
        int pathSum = Math.min(left, right) + triangle[x][y];
        memo.put(hashCode, pathSum);
        return pathSum;
    }
}
