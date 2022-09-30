package senior.dfs.单词搜索;

import java.util.ArrayList;
import java.util.List;

public class 单词搜索2 {

    public List<String> wordSearchII(char[][] board, List<String> words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }

        int n = board.length;
        int m = board[0].length;
        List<String> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                search(board, i, j, trie.root, results);
            }
        }
        return results;
    }

    final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void search(char[][] board, int x, int y, TrieNode now, List<String> results){
        if (!now.child.containsKey(board[x][y])){
            return;
        }

        TrieNode child = now.child.get(board[x][y]);
        if (child.word != null){
            if (!results.contains(child.word)){
                results.add(child.word);
            }
        }
        //这样处理跟  添加一个 visited boolean array same。
        char temp = board[x][y];
        board[x][y] = 0;
        for (int[] direction: DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (isValid(newX, newY, board)){
                continue;
            }
            search(board, newX, newY, child, results);
        }
        board[x][y] = temp;
    }

    private boolean isValid(int x, int y, char[][] board){
        if (x < 0 || x >= board.length){
            return false;
        }
        if (y < 0 || y >= board[0].length){
            return false;
        }
        return board[x][y] != 0;
    }
}
