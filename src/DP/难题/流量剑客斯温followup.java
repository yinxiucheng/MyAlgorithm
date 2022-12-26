package DP.难题;

/**
 *  752.
 *
 *  n+ 1 个星球， 0 ~ n
 *  从星球 i 可以穿越 到星球 i+ 1， i+ 2， i+ limit (不能超过n)
 *
 *  在物质位面“现实”中，有n+1个星球，分别为星球0，星球1，……，星球n。
 *
 * 每一个星球都有一个传送门，通过传送门可以直接到达目标星球而不经过其他的星球。
 *
 * 不过传送门有两个缺点。
 *
 * 第一，从星球i通过传送门只能到达编号比i大，且与i的差不超过limit的星球。
 *
 * 第二，通过传送门到达星球j，需要cost[j]个金币。
 *
 * 现在，流浪剑客斯温到达星球0后身上有m个金币，请问他有多少种方法通过传送门到达星球n？
 *
 * 坐标 + 状态型。
 *
 */
public class 流量剑客斯温followup {

    public long getNumberOfWays(int n, int m, int limit, int[] cost) {
        // 最后一步： 从某个星球 i< n 跳到星球n, 需要保证 i+limit >= n
        // 社状态f[i]表示 有多少种方式 从星球 0 跳到星球i.
        // 从i到cost
        // f[i][j]表示有多少种从星球0 跳到 星球 i， 手里还剩 j枚金币
        // f[i][j] = Sum  {}

        // 答案： f[n][0] + f[n][1] + ... + f[n][m]

        long[][] f = new long[n+1][m+1];
        long[][] sum = new long[n+1][m+1];

        for (int i = 0; i < m; i++) {
            f[0][i] = 0;
            sum[0][i] = 0;
        }

        f[0][m] = 1;//出在0号星球 m个金币。
        sum[0][m] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m ; j++) {
                // f[i][j] 在 i 号星球，手里有 j枚金币。
                f[i][j] = 0;
                sum[i][j] = sum[i-1][j];
                if (j + cost[i] > m){
                    continue;
                }
                //从k 号 星球到i
                f[i][j] = sum[i - 1][j + cost[i]];
                if (i >= limit + 1) {
                    f[i][j] -= sum[i - limit - 1][j + cost[i]];
                }
                sum[i][j] += f[i][j];
            }
        }

        long res = 0;
        for (int j = 0; j <= m ; j++) {
            res += f[n][j];
        }
        return res;
    }

}
