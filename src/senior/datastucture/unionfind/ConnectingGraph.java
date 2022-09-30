package senior.datastucture.unionfind;

/**
 * 589 · 连接图
 *
 * https://www.lintcode.com/course/7/learn/589?chapterId=43&sectionId=2050&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A7%22%7D&ac=false
 *
 * 描述
 * 给一个图中的n个节点, 记为 1 到 n . 在开始的时候图中没有边。
 * 你需要完成下面两个方法:
 *
 * connect(a, b), 添加连接节点 a, b 的边.
 * query(a, b), 检验两个节点是否联通
 */
public class ConnectingGraph {

    int[] father = null;

    /*
     * @param n: An integer
     */
    public ConnectingGraph(int n) {
        father = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            father[i] = i;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int root_b = find(b);
        int root_a = find(a);
        if (root_a != root_b){
            father[root_a] = root_b;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b){
            return false;
        }
        return true;
    }

    private int find2(int x){
       if (x == father[x]){
           return x;
       }
       return father[x] = find2(father[x]);
    }

    private int find(int x){
        int j = x;
        while (j != father[j]){
            j = father[j];
        }
        while (x != j){//状态压缩。
            int fx = father[x];
            father[x] = j;
            x = fx;
        }
        return j;
    }
}
