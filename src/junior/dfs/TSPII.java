package junior.dfs;

/**
 * https://www.lintcode.com/problem/816/
 *
 * 描述
 * 给 n 个城市(从 1 到 n)，城市和无向道路成本之间的关系为3元组 [A, B, C]（在城市 A 和城市 B 之间有一条路，成本是 C）我们需要从1开始找到的旅行所有城市的付出最小的成本。
 */
public class TSPII {
    public static void main(String[] args) {
        int[][] roads =  new int[][]{
                {1, 2, 1},
                {2, 3, 2},
                {1, 3, 3}
        };

        int result = minCost(3, roads);
        System.out.print("the result is " + result);
    }
    /**
     * @param n: an integer,denote the number of cities
     * @param roads: a list of three-tuples,denote the road between cities
     * @return: return the minimum cost to travel all cities
     */
    public static int minCost(int n, int[][] roads) {
        int[][] graph = createGraph(n, roads);
        int stateSize = 1 << n; // 2^n times states
        int[][] dp = new int[stateSize][n + 1]; // stateSize 种状态， n ：以其中任意城市结束的状态有 n 种。 dp值：这种状态下的耗费。
        for (int i = 0; i < stateSize; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE >> 4;
            }
        }
        dp[1][1] = 0;//状态 初始方程，只遍历了 1号城市 的耗费，没有动为 0.

        for (int state = 0; state < stateSize; state++) {
            for (int i = 2; i < n+1; i++) { // 状态为state值时， 以 i城市结尾 ， i从(2 -> n), 其中1 已经被初始化了。
               int iExitState =  state & (1 << (i - 1)); //计算 i 号 城市是否 在state时，存在。
               if (iExitState == 0){ // 当不存在时，直接跳过，因为当前的遍历是以 i 城市结尾，i必须存在为前提。
                   continue;
               }
               int preState = state ^ (1 << (i - 1));// state - 2^(i-1), 把i号城市刨去， 例如从状态15(1111) 把 3号城市 刨去(1011), 从又往左数城市下标数1开始，
                // 所以 15 - 2^(3 - 1) = (1111) - (0100) = (1111)^(0100) = state ^ (1 << (i -1))

                // dp[preState][i] + graph[?][i] = dp[state][i], 以 i 为结尾状态为 state的状态方程。
                // 其中 ？表示除了i以外的任意一座城市结尾（当前是 以i结尾的 preState状态的城市遍历）。 所以 对 ？ 进行（1-> n）迭代, 取 min 值为 dp[state][i]
                for (int j = 1; j < n + 1; j++) { // j
                    if (j == i){
                        continue;
                    }
                    int jExitState = state & (1 << (j - 1));
                    if (jExitState == 0){
                        continue;
                    }
                    dp[state][i] = Math.min(dp[state][i], dp[preState][j] + graph[j][i]);
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n+1; i++) {
            //dp 一维参数 为 stateSize - 1 表示 state值二进制位n全为1的状态，（11…………11）n个1， 表示n个城市都遍历到了。
            minCost = Math.min(minCost, dp[stateSize - 1][i]);
        }
        return minCost;
    }

    //create graph
    private static int[][] createGraph(int n, int[][] roads){
        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) { // init graph
            for (int j = 0; j < n+1; j++) {
                graph[i][j] = Integer.MAX_VALUE >> 4;
            }
        }
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0]; //第一个城市点； 边的起点
            int b = roads[i][1]; //第二个城市点； 边的终点， 可以反过来。
            int cost = roads[i][2]; //边的耗费；
            graph[a][b] = Math.min(graph[a][b], cost);
            graph[b][a] = Math.min(graph[b][a], cost);
        }
        return graph;
    }
}
