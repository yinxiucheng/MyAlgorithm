package senior.dfs.单词搜索;

/**
 * 123 · 单词搜索
 * https://www.lintcode.com/problem/123/?fromId=178&_from=collection
 *
 * 描述
 * 给出一个二维的字母板和一个字符串单词，寻找字母板网格中是否存在这个字符串单词。
 *
 * 字符串单词可以由按顺序的相邻单元的字母组成，其中相邻单元指的是水平或者垂直方向相邻。
 *
 * 每个单元中的字母最多只能使用一次。
 */
public class 单词搜索 {

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (search(board, i, j,0, word)){
                    return true;
                }
            }
        }
        return false;
    }
    final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean search(char[][] board, int x, int y, int index, String word){
        if (board[x][y] == word.charAt(index) && index == word.length() - 1){
            return true;
        }

        if (board[x][y] != word.charAt(index)){
            return false;
        }

        char temp = board[x][y];
        board[x][y] = 0;
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (!isValid(newX, newY, board)){
                continue;
            }
            boolean tempB = search(board, newX, newY, index + 1, word);
            if (tempB){
                return true;
            }
        }
        board[x][y] = temp;
        return false;
    }

    private boolean isValid(int x, int y, char[][] board){
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return false;
        }
        return board[x][y] != 0;
    }
}
