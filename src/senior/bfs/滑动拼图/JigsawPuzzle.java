package senior.bfs.滑动拼图;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 950 · 滑动拼图III
 *
 * https://www.lintcode.com/problem/950/?fromId=178&_from=collection
 *
 *
 * 给定3 x 3的矩阵，标号为1~9，其中8个方格内有数字，1~8，另有一个为空(用0表示)，
 * 问是否能将对应的数字放到对应标号的格子里(空格只能和上下左右位置交换),如果能输出"YES"，否则输出"NO"。
 */
public class JigsawPuzzle {

    int n, m;
    public String  jigsawPuzzle(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;

        String targetStr = "123456780";
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0){
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        String originalStr = convertToStr(matrix);
        State originalState = new State(originalStr, x, y);

        Queue<State>  queue = new ArrayDeque<>();
        queue.offer(originalState);

        Set<String> visited = new HashSet<>();
        visited.add(originalStr);

        while (!queue.isEmpty()){
            State curState = queue.poll();
            if (curState.str.equals(targetStr)) {
               return "YES";
            }
            for (int[] direction: DIRECTIONS) {
                int newX = curState.x + direction[0];
                int newY = curState.y + direction[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m){
                    continue;
                }
                int[][] curMatrix = convertToArray(curState.str);
                int temp = curMatrix[newX][newY];
                curMatrix[newX][newY] = curMatrix[curState.x][curState.y];
                curMatrix[curState.x][curState.y] = temp;

                String newStr = convertToStr(curMatrix);
                if (!visited.contains(newStr)){
                    State newState = new State(newStr, newX, newY);
                    queue.offer(newState);
                    visited.add(newStr);
                }
            }
        }
        return "NO";
    }

    final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private String convertToStr(int[][] matrix){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                builder.append(matrix[i][j]);
            }
        }
        return builder.toString();
    }

    private int[][] convertToArray(String str) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < str.length(); i++) {
            int x = i / m;
            int y = i % m;
            matrix[x][y] = str.charAt(i) - '0';
        }
        return matrix;
    }


    class State{
        int x;
        int y;
        String str;

        public State(String str, int x, int y){
            this.str = str;
            this.x = x;
            this.y = y;
        }
    }
}
