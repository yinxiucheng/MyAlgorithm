package senior.datastucture.unionfind;

import junior.datamodel.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * 434 · 岛屿的个数II
 * <p>
 * 描述
 * 给定 n, m, 分别代表一个二维矩阵的行数和列数, 并给定一个大小为 k 的二元数组A. 初始二维矩阵全0. 二元数组A内的k个元素代表k次操作,
 * 设第i个元素为 (A[i].x, A[i].y), 表示把二维矩阵中下标为A[i].x行A[i].y列的元素由海洋变为岛屿.
 * 问在每次操作之后, 二维矩阵中岛屿的数量. 你需要返回一个大小为k的数组.
 */
public class NumIslands2 {

    final int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1, 0}};

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        UnionFind3 unionFind = new UnionFind3(n, m);
        int[][] grid = new int[n][m];
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for (Point point: operators) {
            int x = point.x;
            int y = point.y;
            if (grid[x][y] == 0){
                int id = unionFind.convertToId(point.x, point.y, m);
                count ++;
                grid[x][y] = 1;
                for (int i = 0; i < 4; i++) {
                    int newX = x + DIRECTIONS[i][0];
                    int newY = y + DIRECTIONS[i][1];
                    if (!isValid(newX, newY, grid)){
                        continue;
                    }
                    if (grid[newX][newY] == 1){
                        int newId = unionFind.convertToId(newX, newY, m);
                        int root_a = unionFind.compress_find(id);
                        int root_b = unionFind.compress_find(newId);
                        if (root_a != root_b){
                            count--;
                            unionFind.union(root_a, root_b);
                        }
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private boolean isValid(int x, int y, int[][] grid){
        if (x < 0 || x >= grid.length){
            return false;
        }
        if (y < 0 || y >= grid[0].length){
            return false;
        }
        return true;
    }
}
