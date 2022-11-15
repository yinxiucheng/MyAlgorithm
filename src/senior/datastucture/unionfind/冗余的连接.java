package senior.datastucture.unionfind;

/**
 * 1088 · 冗余的连接
 *
 * https://www.lintcode.com/problem/1088/description?showListFe=true&page=1&problemTypeId=2&tagIds=399&pageSize=50
 *
 */
public class 冗余的连接 {

    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        if (null == edges || edges.length == 0 ){
            return  res;
        }

        UnionFind_5 unionFind = new UnionFind_5();

        for (int[] edge: edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            if (!unionFind.merge(nodeA, nodeB)){
                res[0] = nodeA;
                res[1] = nodeB;
                return res;
            }
        }
        return res;
    }

    //输入2D数组的大小将介于3和1000之间
    class UnionFind_5{
        int[] farther;

        public UnionFind_5(){
            farther = new int[1001];
            for (int i = 1; i <= 1000 ; i++) {
                farther[i] = i;
            }
        }

        public int find(int x){
            int root, fx = x;
            while (fx != farther[fx]){
                fx = farther[fx];
            }
            root = fx;
            return root;
        }

        public boolean merge(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b){
                farther[root_a] = root_b;
                return true;
            }else {
                return false;//有环
            }
        }

    }
}
