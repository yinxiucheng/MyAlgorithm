package junior.bfs.shortpath;

import java.util.*;

/**
 * 941 · 滑动拼图
 *
 * https://www.lintcode.com/problem/941
 *
 * 描述
 * 在一块大小为 2x3 的板上，有 5 块瓦片，分别用整数 1 到 5 表示，还有一块空地用 0 表示。
 *
 * 一次移动表示 0 与其相邻的四个方向之一的数字交换位置。
 *
 * 当且仅当 这块板 上的瓦片摆放状态为 [[1,2,3],[4,5,0]] 时，才能说这块板存在的问题被解决了。
 *
 * 给定一个拼图板，返回所需的最少移动次数，以解决该板的状态。如果无法解决板的状态，则返回-1。
 */
public class SlidingPuzzle {

    public static void main(String[] args) {
        int[][] board = {{1, 2, 3},{4, 0, 5}};
        int result = slidingPuzzle(board);
        System.out.println("the result is " + result);

    }
    /**
     * @param board: the given board
     * @return:  the least number of moves required so that the state of the board is solved
     */
    public static int slidingPuzzle(int[][] board) {
        // write your code here
        String startStr = getStrFromMatrix(board);
        String destinationStr = "123450";

        Queue<String> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        queue.offer(startStr);
        visited.put(startStr, true);
        int times = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            times ++;
            for (int i = 0; i < size; i++) {
                String curStr = queue.poll();
                for (String neighborStr: getNextStrs(curStr)) {
                    if (neighborStr.equals(destinationStr)){
                        return times;
                    }
                    if (!visited.containsKey(neighborStr)){
                        queue.offer(neighborStr);
                        visited.put(neighborStr, true);
                    }
                }
            }
        }
        return -1;
    }

    private static List<String> getNextStrs(String originalStr){
        List<String> list = new ArrayList<>();
        int zeroIndex = originalStr.indexOf("0");
        int x = zeroIndex / 3;
        int y = zeroIndex % 3;
        int[][] direction = {{1,0},{0, 1},{-1, 0},{0, -1}};
        for (int i = 0; i < 4 ; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (newX < 0 || newX >= 2 || newY < 0 || newY >= 3){
                continue;
            }
            int newIndex = newX * 3 + newY;
            Character c = originalStr.charAt(newIndex);
            String neighborStr = originalStr.substring(0, newIndex) + "0" + originalStr.substring(newIndex + 1);
            neighborStr = neighborStr.substring(0, zeroIndex) + c + neighborStr.substring(zeroIndex + 1);
            list.add(neighborStr);
        }
        return list;
    }


    private static String getStrFromMatrix(int[][] board){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                buffer.append(board[i][j]);
            }
        }
        return buffer.toString();
    }
}
