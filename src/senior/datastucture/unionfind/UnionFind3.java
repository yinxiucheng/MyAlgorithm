package senior.datastucture.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * 二维坐标 并查集
 */
public class UnionFind3 {

    //降维处理
    Map<Integer, Integer> father;

    public int convertToId(int x, int y, int m){
        return x * m + y;
    }

    public UnionFind3(int n, int m){
        father = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int id = convertToId(i, j, m);
                father.put(id, id);
            }
        }
    }

    public void union(int a, int b){
        int root_a = compress_find(a);
        int root_b = compress_find(b);
        if (root_a != root_b){
            father.put(root_a, root_b);
        }
    }

    public int compress_find(int x){
        int root = x, fx;
        while (root != father.get(root)){
            root = father.get(root);
        }

        while (x != root){//路径压缩
            fx = father.get(x);
            father.put(x, root);
            x = fx;
        }
        return root;
    }

}
