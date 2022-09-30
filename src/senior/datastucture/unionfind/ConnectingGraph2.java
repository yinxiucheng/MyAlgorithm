package senior.datastucture.unionfind;

/**
 * 590. 连接图II
 *
 * 描述
 * 给一个图中的 n 个节点, 记为 1 到 n .在开始的时候图中没有边.
 * 你需要完成下面两个方法：
 *
 * connect(a, b), 添加一条连接节点 a, b的边
 * query(a), 返回图中含 a 的联通区域内节点个数
 *
 *
 */
public class ConnectingGraph2 {

    private int[] father = null;
    private int[] size  = null;


    /*
     * @param n: An integer
     */
    public ConnectingGraph2(int n) {
        father = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b){
            father[root_a] = root_b;
            size[root_b] += size[root_a];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        int root_a = find(a);
        return size[root_a];
    }

    private int find(int x){
        int j = x, fx;
        while (j != father[j]){
            j = father[j];
        }

        while (x != j){
            fx = father[x];
            father[x] = j;
            x = fx;
        }
        return j;
    }
}
