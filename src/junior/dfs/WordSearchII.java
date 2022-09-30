package junior.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/132/solution/16661?fromId=161&_from=collection
 * 描述
 * 给出一个由小写字母组成的矩阵和一个字典。找出所有同时在字典和矩阵中出现的单词。
 * 一个单词可以从矩阵中的任意位置开始，可以向左/右/上/下四个相邻方向移动。
 * 一个字母在一个单词中只能被使用一次。且字典中不存在重复单词
 */
public class WordSearchII {

    public static void main(String[] args) {
        /**
         * ["abce","sfcs","adee"]
         * ["see","se"]
         */
        char[][] board = new char[][]{
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        List<String> words = new ArrayList<String>();
        words.add("see");
        words.add("se");
//        words.add("dad");

        List<String> results = wordSearchII(board, words);
        for (String result: results) {
            System.out.println(" " + result);
        }
    }

    public static List<String> wordSearchII(char[][] board, List<String> words){
        List<String> results = new ArrayList<>();
        if (null == board || board.length == 0){
            return results;
        }
        if (board[0] == null || board[0].length == 0){
            return results;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Map<String, Boolean> prefixIsWord = getPrefixSet(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                dfs(i, j, visited, board, String.valueOf(board[i][j]), prefixIsWord, results);
                visited[i][j] = false;
            }
        }
        return results;
    }

    private static void dfs(int x, int y, boolean[][] visited, char[][] board, String word, Map<String, Boolean> prefixIsWord, List<String> results ){
        if (!prefixIsWord.containsKey(word)){//不在前缀里， 剪枝
            return;
        }
        if (prefixIsWord.get(word) && !results.contains(word)){//找到答案。
            results.add(word);
        }
        for (int i = 0; i < Directions.length; i++) {
            int xLocation  = x + Directions[i][0];
            int yLocation  = y +  Directions[i][1];

            if (!isInBoard(xLocation, yLocation, board) || visited[xLocation][yLocation]) {// 越界
                continue;
            }
            visited[xLocation][yLocation] = true;
            dfs(xLocation, yLocation, visited, board, word + board[xLocation][yLocation], prefixIsWord, results);
            visited[xLocation][yLocation] = false;
        }
    }

    private static boolean isInBoard(int x, int y, char[][] board){
        boolean xInboard = x >= 0 && x < board.length;//判断 x 边界
        boolean yInboard = y >= 0 && y < board[0].length;// 判断 y 边界
        return xInboard && yInboard;
    }

    //构建 HashMap的前缀。
    private static HashMap<String, Boolean> createdPreFix(List<String> words) {
        HashMap<String, Boolean> prefixIsWord = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                builder.append(chars[i]);
                if (!prefixIsWord.containsKey(builder.toString())){
                    if (builder.length() < chars.length) {
                        prefixIsWord.put(builder.toString(), false);
                    } else {
                        prefixIsWord.put(builder.toString(), true);
                    }
                }
            }
        }
        return prefixIsWord;
    }

    private static Map<String, Boolean> getPrefixSet(List<String> words) {
        Map<String, Boolean> prefixIsWord = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                String prefix = word.substring(0, i + 1);
                if (!prefixIsWord.containsKey(prefix)) {
                    prefixIsWord.put(prefix, false);
                }
            }
            prefixIsWord.put(word, true);
        }

        return prefixIsWord;
    }

    public static final int[][] Directions = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};

}
