package senior.datastucture.unionfind;

import junior.datamodel.Point;

import java.util.*;

/**
 * 二维 降 1维。
 * 动态修改 岛屿 ，将0变为1；
 */
public class UnionFind5 {

    Map<Integer, Integer> father;

    final int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1, 0}};
    int[][] grid;
    int n, m;

    public int convertId(int x, int y, int m){
        return x * m + y;
    }

    public UnionFind5(int n, int m){
        this.n = n;
        this.m = m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int id = convertId(i, j, m);
                father.put(id, id);
            }
        }
        grid = new int[n][m];
    }

    public void union(int a, int b){
        int root_a = compress_find(a);
        int root_b = compress_find(b);
        if (root_a != root_b){
            father.put(root_a, root_b);
        }
    }

    public int compress_find(int x){
        int root = x, fx, fa = x;
        while (root != father.get(root)){
            root = father.get(root);
        }
        while (fa != root){//路径压缩
            fx = father.get(fa);
            father.put(fa, root);
            fa = fx;
        }
        return root;
    }

    public void changeToIsland(Point point){
        int x = point.x;
        int y = point.y;
        if (grid[x][y] == 1){
            return;
        }
        grid[x][y] = 1;
        for (int i = 0; i < 4; i++) {//处理四个方位的合并问题
            int newX = x + DIRECTIONS[i][0];
            int newY = y + DIRECTIONS[i][1];
            if (newX>= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1){
                int id = convertId(x, y, m);
                int newId = convertId(newX, newY, m);
                union(id, newId);
            }
        }
    }

    //根据 UnionFind build graph. 大于 1的 岛屿。
    public Map<Integer, Set<Integer>> buildGraph(){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: father.entrySet()) {
            if (entry.getKey() == entry.getValue()){
                continue;
            }
            Set<Integer> path = new HashSet<>();
            int cur = entry.getKey();
            while (cur != father.get(cur)){
                path.add(cur);
                cur = father.get(cur);
            }
            path.add(cur);
            Set<Integer> collection = graph.getOrDefault(cur, new HashSet<>());
            collection.addAll(path);
            graph.put(cur, collection);
        }
        return graph;
    }


}
