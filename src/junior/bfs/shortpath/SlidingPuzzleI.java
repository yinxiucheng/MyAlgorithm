package junior.bfs.shortpath;

import java.util.*;

/**
 * 794 · 滑动拼图 II
 *
 * https://www.lintcode.com/problem/794/solution
 *
 * 描述
 * 在一个3x3的网格中，放着编号1到8的8块板，以及一块编号为0的空格。
 * 一次移动可以把空格0与上下左右四邻接之一的板子交换。
 * 给定初始和目标的板子排布，返回到目标排布最少的移动次数。
 * 如果不能从初始排布移动到目标排布，返回-1.
 *
 * 输入:
 * [
 *  [2,8,3],
 *  [1,0,4],
 *  [7,6,5]
 * ]
 * [
 *  [1,2,3],
 *  [8,0,4],
 *  [7,6,5]
 * ]
 * 输出:
 * 4
 *
 * 解释:
 * [                 [
 *  [2,8,3],          [2,0,3],
 *  [1,0,4],   -->    [1,8,4],
 *  [7,6,5]           [7,6,5]
 * ]                 ]
 *
 * [                 [
 *  [2,0,3],          [0,2,3],
 *  [1,8,4],   -->    [1,8,4],
 *  [7,6,5]           [7,6,5]
 * ]                 ]
 *
 * [                 [
 *  [0,2,3],          [1,2,3],
 *  [1,8,4],   -->    [0,8,4],
 *  [7,6,5]           [7,6,5]
 * ]                 ]
 *
 * [                 [
 *  [1,2,3],          [1,2,3],
 *  [0,8,4],   -->    [8,0,4],
 *  [7,6,5]           [7,6,5]
 * ]                 ]
 */
public class SlidingPuzzleI {

    public int minMoveStep(int[][] initState, int[][] finalState) {
        String originalStr = matrixToString(initState);
        String destinationStr = matrixToString(finalState);

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance =  new HashMap<>();
        queue.offer(originalStr);
        distance.put(originalStr, 0);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curStr = queue.poll();
                if (curStr.equals(destinationStr)){
                    return distance.getOrDefault(curStr, 0);
                }
                for (String neighborStr: getNextStrs(curStr)) {
                    if (distance.containsKey(neighborStr)) {
                        continue;
                    }
                    queue.offer(neighborStr);
                    distance.put(neighborStr, distance.getOrDefault(curStr, 0) + 1);
                }
            }
        }
        return -1;
    }

    private List<String> getNextStrs(String originalStr){
        List<String> resultList = new ArrayList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int zeroIndex = originalStr.indexOf('0');
        int x = zeroIndex / 3;
        int y = zeroIndex % 3;

        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX < 0 || newX >= 3 || newY < 0 || newY >= 3) {
                continue;
            }
            char[] chars = originalStr.toCharArray();
            chars[zeroIndex] = chars[newX * 3 + newY];
            chars[newX * 3 + newY] = '0';
            resultList.add(new String(chars));
        }
        return resultList;
    }

    public String matrixToString(int[][] state) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(state[i][j]);
            }
        }
        return sb.toString();
    }
}
