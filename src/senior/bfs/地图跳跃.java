package senior.bfs;

import java.util.*;

/**
 * 258 · 地图跳跃
 *
 * https://www.lintcode.com/problem/258/?fromId=178&_from=collection
 *
 * 描述
 * 给定n×n的地图，每个单元都有一个高度，每次你只能够往相邻的单元格移动，并且要求这两个单元格的高度差不超过target。你不能走出地图之外。
 * 求出满足从左上角(0,0)走到右下右下角(n-1,n-1)最小的target。
 *
 */
public class 地图跳跃 {

    final int[][] DIRECTIONS = {{1, 0},{0, 1},{0, -1},{-1, 0}};

    public int mapJump(int[][] arr) {
        int n = arr.length;
        int originalId = hash(0, 0, n);
        int targetId = hash(n-1, n-1, n);

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(originalId);
        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(originalId, 0);

        while (!queue.isEmpty()){
           int curId =  queue.poll();
           int curX = curId / n;
           int curY = curId % n;
           if (curId == targetId){
               return distance.get(curId);
           }
           for (int[] direction: DIRECTIONS) {
                int newX = curX + direction[0];
                int newY = curY + direction[1];
                if (!isInRange(newX, newY, n)){
                    continue;
                }
                int newId = hash(newX, newY, n);
                int newDistance = Math.abs(arr[newX][newY] - arr[curX][curY]);
                newDistance = Math.max(newDistance, distance.get(curId));
                if (newDistance < distance.getOrDefault(newId, Integer.MAX_VALUE)){// def
                    distance.put(newId, newDistance);
                    queue.offer(newId);
                }
            }
        }
        return distance.getOrDefault(targetId, -1);
    }

    private boolean isInRange(int x, int y, int n){
        if (x < 0 || x >= n){
            return false;
        }
        if (y < 0 || y >= n){
            return false;
        }
        return true;
    }

    private int hash(int x, int y, int m){
        return x * m + y;
    }

}
