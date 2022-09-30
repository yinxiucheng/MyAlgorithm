package junior.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/802/solution?fromId=161&_from=collection
 */
public class SolvedSudokuII {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 9, 7, 4, 8, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 1, 0, 9, 0, 0, 0},
                {0, 0, 7, 0, 0, 0, 2, 4, 0},
                {0, 6, 4, 0, 1, 0, 5, 9, 0},
                {0, 9, 8, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 8, 0, 3, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 2, 7, 5, 9, 0, 0}
        };
        solvedSudoku(board);
    }

    public static void solvedSudoku(int[][] board) {
        dfs(board);
    }

    private static boolean dfs(int[][] board) {
        Point leastPoint = getLeastChoiceGrid(board);//获取当前可选
        if (null == leastPoint) {//退出条件
            return true;
        }
        int x = leastPoint.x;
        int y = leastPoint.y;
        for (int val : leastPoint.choices) {
            if (!isValid(val, x, y, board)) {
                continue;
            }
            board[x][y] = val;
            if (dfs(board)) return true;
            board[x][y] = 0;
        }
        return false;
    }

    private static boolean isValid(int val, int x, int y, int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == val) return false;
            if (board[i][y] == val) return false;
            if (board[x / 3 * 3 + i / 3][y / 3 * 3 + i % 3] == val) return false;
        }
        return true;
    }

    private static Point getLeastChoiceGrid(int[][] board) {
        Point leastPoint = null;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] != 0) {
                    continue;
                }
                List<Integer> choices = new ArrayList<>();
                for (int val = 1; val <= 9; val++) {
                    if (isValid(val, x, y, board)) {
                        choices.add(val);
                    }
                }
                if (leastPoint == null || leastPoint.choices.size() > choices.size()) {
                    leastPoint = new Point(x, y);
                    leastPoint.choices = choices;
                }
                if (leastPoint != null && leastPoint.choices.size() == 1) {
                    return leastPoint;
                }
            }
        }
        return leastPoint;
    }

    static class Point {
        int x;
        int y;
        List<Integer> choices;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
