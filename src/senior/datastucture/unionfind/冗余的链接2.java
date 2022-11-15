package senior.datastucture.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * 1087 · 冗余的连接 II
 *
 * https://www.lintcode.com/problem/1087/?showListFe=true&page=1&problemTypeId=2&tagIds=399&pageSize=50
 *
 */
public class 冗余的链接2 {

    //
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;
        int[] res = new int[2];
        if (null == edges || edges.length == 0){
            return res;
        }

        //key, value
        Map<Integer, Integer> childToParent = new HashMap<>();
        int[] candidate1 = null;
        int[] candidate2 = null;
        for (int[] edge: edges) { // u -> v,  表示 u的子节点为 v;
            int u = edge[0];
            int v = edge[1];
            if (childToParent.containsKey(v)){
                candidate1 = new int[]{childToParent.get(v), v};
                candidate2 = new int[]{u, v};
                edge[0] = edge[1] = -1;//删除其中一条边
            }
            childToParent.put(v, u);
        }

        UnionFind_6 unionFind = new UnionFind_6(N);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (u < 0 || v < 0){
                continue;
            }
            if (unionFind.connect(u, v)){
                return candidate1 == null ? edge : candidate1;
            }
        }
        return candidate2;
    }

    class UnionFind_6{
        int[] father;
        public UnionFind_6(int n){
            father = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                father[i] = i;
            }
        }

        public boolean connect(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b){
                father[root_a] = root_b;
                return false;
            }
            return true;
        }

        public int find(int x){
            int fx = x, root;
            while (fx != father[fx]){
                fx = father[fx];
            }
            root = fx;
            return root;
        }
    }
}
