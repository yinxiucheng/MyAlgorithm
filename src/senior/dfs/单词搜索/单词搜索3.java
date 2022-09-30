package senior.dfs.单词搜索;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1848 · 单词搜索 III
 *
 * 描述
 * 给出一个由小写字母组成的矩阵和一个字典。找出最多同时可以在矩阵中找到的字典中出现的单词数量。
 * 一个单词可以从矩阵中的任意位置开始，可以向左/右/上/下四个相邻方向移动。一个字母在整个矩阵中只能被使用一次。且字典中不存在重复单词。
 */
public class 单词搜索3 {

    class TrieTree{
        public TrieNode root;
        public TrieTree(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (curNode.child.get(c) == null){
                    curNode.child.put(c, new TrieNode());
                }
                curNode = curNode.child.get(c);
            }
            curNode.word = word;
        }
    }

    class TrieNode{
        public String word;
        public Map<Character, TrieNode> child;

        public TrieNode(){
            child = new HashMap<>();
        }
    }

    public int wordSearchIII(char[][] board, List<String> words) {
        TrieTree trie = new TrieTree();
        for (String word : words) {
            trie.insert(word);
        }
        int n = board.length;
        int m = board[0].length;

        int[] ans = {0};
        List<String> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               search(board, i, j, i, j, trie.root, trie.root, results, ans);
            }
        }
        return ans[0];
    }
    final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void search(char[][] board, int x, int y,int start_x, int start_y, TrieNode now, TrieNode root,  List<String> results, int[] ans){
        //1. 出口
        if (!now.child.containsKey(board[x][y])){
            return;
        }

        //2. 递归
        TrieNode child = now.child.get(board[x][y]);
        Character temp = board[x][y];
        board[x][y] = 0;

        if (child.word != null){
            results.add(child.word);
            ans[0] = Math.max(ans[0], results.size());
            System.out.println("ans size :" + ans[0] + " current word: " + child.word );
            String tempWord = child.word;

            child.word = null;
            //从上次的 start_x, start_y的下一个位置开始找。
            for (int i = start_x; i < board.length; i++) {
                int startJ = 0;
                if (i == start_x){
                    startJ = start_y + 1;
                }
                for (int j = startJ; j < board[0].length; j++) {
                    if (isValid(i, j, board)){
                        search(board, i, j, i, j, root, root, results, ans);
                    }
                }
            }
            //todo 这里的回溯，比较难理解。
            results.remove(results.size() - 1);
            child.word = tempWord;
        }
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (!isValid(newX, newY, board)){
                continue;
            }
            search(board, newX, newY, start_x, start_y, child, root, results, ans);
        }
        board[x][y] = temp;
    }

    private boolean isValid(int x, int y, char[][] board){
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return false;
        }
        return board[x][y] != 0;
    }
}
