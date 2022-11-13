package senior.datastucture.unionfind;

/**
 * 1857 · 寻找朋友圈数
 *
 * https://www.lintcode.com/problem/1857/?showListFe=true&page=1&problemTypeId=2&tagIds=399&pageSize=50
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 */
public class 寻找朋友圈数 {

    public int findCircleNum(int[][] m) {
        int N = m.length;
        UnionFind_3 unionFind = new UnionFind_3(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (m[i][j] == 1){
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.getUnionSize();

    }

    class UnionFind_3{
        int[] father;
        int sizeUnion;

        UnionFind_3(int n){
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
                sizeUnion ++;
            }
        }

        public int getUnionSize(){
            return sizeUnion;
        }

        public void union(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b){
                father[root_a] = root_b;
                sizeUnion --;
            }
        }

        public int find(int x){
           int root, fx = x, now = x;
           while (now != father[now]){
               now = father[now];
           }
           root = now;
           while (fx != root){
               father[fx] = root;
               fx = father[fx];
           }
           return root;
        }
    }
}
