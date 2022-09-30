package junior.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/34/?fromId=161&_from=collection
 * 描述
 * 根据 N 皇后问题，现在返回 N 皇后不同的解决方案的数量而不是具体的放置布局。
 */
public class TotalNQueens {

    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public static int totalNQueens(int n) {
        if (n <= 0){
            return  result;
        }
        List<Integer> cols = new ArrayList<>();
        Set<Integer> colsVisited = new HashSet<>();
        Set<Integer> sum = new HashSet<>();
        Set<Integer> diff =  new HashSet<>();

        dfs(n, cols, colsVisited, sum, diff);
        return result;
    }

    static int result = 0;

    private static void dfs(int n, List<Integer> cols, Set<Integer> colsVisited, Set<Integer> sum, Set<Integer> diff){
        int row = cols.size();
        if (row == n){
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (colsVisited.contains(col) || sum.contains(row + col) || diff.contains(row - col)){
                continue;
            }
            cols.add(col);
            colsVisited.add(col);
            sum.add(row + col);
            diff.add(row - col);
            dfs(n, cols, colsVisited, sum, diff);
            colsVisited.remove(col);
            sum.remove(row + col);
            diff.remove(row - col);
            cols.remove(cols.size() - 1);
        }
    }

    public static void main(String[] args) {
        int result = totalNQueens(1);
        System.out.print("the result is " + result);

    }

}
