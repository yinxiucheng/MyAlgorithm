package junior.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/33/
 *
 * 描述
 * N皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击(任意两个皇后不能位于同一行，同一列，同一斜线)。
 * 给定一个整数n，返回所有不同的N皇后问题的解决方案。
 * 每个解决方案包含一个明确的N皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。
 *
 */
public class SolveNQueens {

    public static void main(String[] args) {
        List<List<String>> queens = solveNQueens(1);
    }

    public static List<List<String>> solveNQueens(int n){
        List<List<String>> results = new ArrayList<>();
        if (n <= 0){
            return results;
        }
        List<Integer> columns = new ArrayList<>();
        dfs(n, columns, results);
        return results;
    }

    private static void dfs(int n, List<Integer> columns, List<List<String>> results){
        int row = columns.size();
        if (n == row){
            List<String> columnsStr = createNQueens(columns);
            results.add(columnsStr);
            return;
        }
        for (int col = 0; col < n ; col++) {
            if (!isValid(row, col, columns)){
                continue;
            }
            columns.add(col);
            dfs(n, columns, results);
            columns.remove(columns.size() - 1);
        }
    }

    private static boolean isValid(int row, int col, List<Integer> columns){
        for (int row1 = 0; row1 < columns.size(); row1++) {
            int col1 = columns.get(row1);
            if (col == col1) return false;
            if (row + col == row1 + col1) return false;
            if (row - col == row1 - col1) return false;
        }
        return true;
    }

    private static List<String> createNQueens(List<Integer> columns){
        List<String> result = new ArrayList<>();
        for (int row = 0; row < columns.size(); row++) {
            StringBuilder builder = new StringBuilder();
            for (int col = 0; col < columns.size(); col++) {
                if (columns.get(row) == col){
                    builder.append("Q");
                }else{
                    builder.append(".");
                }
            }
            result.add(builder.toString());
        }
        return result;
    }
}
