package senior.presum;

import java.util.HashSet;
import java.util.Set;

/**
 * 389 · 判断数独是否合法
 *
 * https://www.lintcode.com/problem/389/?fromId=178&_from=collection
 *
 *
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
       boolean b =  isValidSudoku(board);
       System.out.println("the result is " + b);
    }

    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;

        for (int row = 0; row < n; row++) {
            char[] rows = board[row];
            if (!checkIsValid(rows)){
                return false;
            }
        }

        for (int col = 0; col < n; col++) {
            char[] chars = new char[n];
            for (int i = 0; i < 9; i++) {
                chars[i] = board[i][col];
            }
            if (!checkIsValid(chars)){
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char[] chars = new char[n];
                int count = 0;
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        chars[count ++] = board[i* 3 + row][j* 3 + col];
                    }
                }
                if (!checkIsValid(chars)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkIsValid(char[] chars){
        Set<Character> set = new HashSet<>();
        for (Character c : chars) {
            if (c == '.') {
                continue;
            } else {
                if (c > '9' || c < '0') {
                    return false;
                }
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        return true;
    }
}
