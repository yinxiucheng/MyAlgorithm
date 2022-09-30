package junior.dfs;

/**
 * https://www.lintcode.com/problem/802/?fromId=161&_from=collection
 * <p>
 * 描述
 * 编写一个程序，通过填充空单元来解决数独难题。
 * 空单元由数字0表示。
 * 你可以认为只有一个唯一的解决方案。
 */
public class SolvedSudoku {

    /**
     * @param board: the sudoku puzzle
     * @return: nothing
     */
    public void solveSudoku(int[][] board) {
        // write your code here
        int index = 0;
        dfs(index, board);
    }

    private boolean dfs(int index, int[][] board) {
        if (index == 81) {
            return true;
        }
        int x = index / 9, y = index % 9;
        if (board[x][y] != 0) {
            dfs(index + 1, board);
        }
        for (int value = 1; value <= 9; value++) {
            if (!isValid(value, x, y, board)) {
                continue;
            }
            board[x][y] = value;
            if (dfs(index + 1, board)) {
                return true;
            }
            board[x][y] = 0;
        }
        return false;
    }

    private boolean isValid(int val, int x, int y, int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == val) return false;
            if (board[i][y] == val) return false;
            if (board[x / 3 * 3 + i / 3][y / 3 * 3 + i % 3] == val) return false;
        }
        return true;
    }

}
