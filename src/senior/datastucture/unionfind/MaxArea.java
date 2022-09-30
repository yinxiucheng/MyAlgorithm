package senior.datastucture.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * 261 · 最大连通面积
 *
 * https://www.lintcode.com/problem/261/description?fromId=178&_from=collection
 *
 */
public class MaxArea {

    final int[][] DIRECTIONS = {{0,1},{1, 0},{0, -1},{-1,0}};
    public int maxArea(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        UnionFind2 unionFind = new UnionFind2(n * m);
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0){
                    zeroCount ++;
                    continue;
                }
                for (int[] direction: DIRECTIONS) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (isInRange(x, y, matrix) && matrix[x][y] == 1){
                        unionFind.union(convertToId(i, j, m), convertToId(x, y, m));
                    }
                }
            }
        }

        if (zeroCount == 0){
            return n * m;
        }

        int maxAreaSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if (matrix[i][j] == 1){
                    continue;
                }
                int areaSize = 1;
                Set<Integer> roots = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                   int x = i + DIRECTIONS[k][0];
                   int y = j + DIRECTIONS[k][1];
                   if (isInRange(x, y, matrix) && matrix[x][y] == 1){
                       int id = convertToId(x, y, m);
                       int root_id = unionFind.compress_find(id);
                       if (!roots.contains(root_id)){
                           roots.add(root_id);
                           areaSize += unionFind.getSize(root_id);
                       }
                   }
                   maxAreaSize = Math.max(maxAreaSize, areaSize);
                }
            }
        }
        return maxAreaSize;
    }

    private boolean isInRange(int x, int y, int[][] matrix){
        if (x < 0 || x >= matrix.length){
            return false;
        }
        if (y < 0 || y >= matrix[0].length){
            return false;
        }
        return true;
    }

    private int convertToId(int x, int y, int m){
        return x * m + y;
    }
}
