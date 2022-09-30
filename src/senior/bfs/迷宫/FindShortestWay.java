package senior.bfs.迷宫;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 789 · 迷宫III
 *
 * https://www.lintcode.com/problem/789/?fromId=178&_from=collection
 *
 *
 */
public class FindShortestWay {

    final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    final String[] HASH = {"r", "d", "l", "u"};

    public  String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length;
        int m = maze[0].length;

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Pair> distance = new HashMap<>();
        int originalId = hash(ball[0], ball[1], m);
        int targetId = hash(hole[0], hole[1], m);

        queue.offer(originalId);
        distance.put(originalId, new Pair(0, ""));

        while (!queue.isEmpty()){
            int curId = queue.poll();
            if (curId == targetId){
                continue;
            }
            int curX = curId / m, curY = curId % m;
            for (int i = 0; i < 4; i++) {
                int newId = kickBall(curX, curY, maze, DIRECTIONS[i], targetId);
                if (newId == curId){
                    continue;
                }
                Pair curPair = distance.get(curId);
                int newX = newId / m;
                int newY = newId % m;
                int newLen = curPair.len + Math.abs(curX - newX) + Math.abs(curY - newY);
                String newPath = curPair.path + HASH[i];
                Pair newPair = new Pair(newLen, newPath);
                if (distance.containsKey(newId) && distance.get(newId).isLessOrEquals(newPair)){
                    continue;
                }
                distance.put(newId, newPair);
                queue.offer(newId);
            }
        }
        if (distance.containsKey(targetId)){
            return distance.get(targetId).path;
        }
        return "impossible";
    }

    private int kickBall(int curX, int curY, int[][] maze, int[] direction, int targetId){
        int m = maze[0].length;
        int holeX = targetId / m, holeY = targetId % m;
        int newX = curX + direction[0], newY = curY + direction[1];
        while (isValid(newX, newY, maze)){
            if (newX == holeX && newY == holeY){
                return targetId;
            }
            if (maze[newX][newY] == 1){
                break;
            }
            newX += direction[0];
            newY += direction[1];
        }
        return hash(newX - direction[0], newY - direction[1], m);
    }

    private boolean isValid(int x, int y, int[][] maze){
        if (x < 0 || x >= maze.length){
            return false;
        }
        if (y < 0 || y >= maze[0].length){
            return false;
        }
        return true;
    }

    class Pair implements Comparable<Pair>{
        public int len;
        public String path;

        public Pair(int len, String path){
            this.len = len;
            this.path = path;
        }

        @Override
        public int compareTo(Pair o) {
            int diff = len - o.len;
            if (diff == 0){
                diff = path.compareTo(o.path);
            }
            return diff;
        }

        public boolean isLessOrEquals(Pair pair){
            return this.compareTo(pair) <= 0;
        }
    }

    private int hash(int x, int y, int m){
        return x * m + y;
    }
}
