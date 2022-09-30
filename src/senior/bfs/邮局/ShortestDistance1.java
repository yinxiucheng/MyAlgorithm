package senior.bfs.邮局;

import java.util.HashSet;
import java.util.Set;

/**
 * 574 · 邮局的建立
 *
 * https://www.lintcode.com/problem/574/?fromId=178&_from=collection
 */
public class ShortestDistance1 {

    final int TYPE_EMPTY = 0;
    final int TYPE_HOUSE = 1;

    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<Integer> emptySet = new HashSet<>();
        Set<Integer> houseSet = new HashSet<>();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == TYPE_EMPTY){
                    emptySet.add(hash(i, j, m));
                }else if (grid[i][j] == TYPE_HOUSE){
                    houseSet.add(hash(i, j, m));
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        int minId = -1;
        for (Integer emptyId: emptySet) {
            int distance = getDistance(emptyId, houseSet, m);
            if (distance < minDistance){
                minId = emptyId;
            }
            minDistance = Math.min(distance, minDistance);
        }
        System.out.println( " x:" + minId/m + " y:" + minId % m);
        return minDistance;
    }

    private int getDistance(int id, Set<Integer> houseSet, int m){
        int x = id / m, y = id % m;
        int sumDistance = 0;
        for (Integer houseId: houseSet) {
            int houseX = houseId / m, houseY = houseId % m;
            sumDistance += Math.abs(x - houseX) + Math.abs(y - houseY);
        }
        return sumDistance;
    }



    private int hash(int x, int y, int m){
        return x * m  + y;
    }
}
