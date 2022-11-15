package senior.datastucture.unionfind;

/**
 * https://www.lintcode.com/problem/1411/description?showListFe=true&page=1&problemTypeId=2&tagIds=399&pageSize=50
 *
 * 1411 · 编辑距离 - 替换版本
 *
 */
public class 编辑距离_替换版本 {

    public int editDistance(String s1, String s2) {
        UnionFind_7 unionFind = new UnionFind_7();
        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            unionFind.union(a, b);
        }
        return unionFind.times;
    }

    class UnionFind_7{
        int[] father = new int[26];
        int times = 0;

        public UnionFind_7(){
            for (int i = 0; i < 26; i++) {
                father[i] = i;
            }
        }

        public void union(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b){
                times++;
                father[root_a] = root_b;
            }
        }

        public int find(int x){
            int root, fx = x;
            while (fx != father[fx]){
                fx = father[fx];
            }
            root = fx;
            return root;
        }

    }
}
