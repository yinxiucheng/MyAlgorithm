package junior.dp.sequence;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 602.俄罗斯套娃信封
 * 坐标型DP， 这里DFS
 * https://www.lintcode.com/problem/602/solution?fromId=161&_from=collection
 *
 * 描述
 * 给一定数量的信封，带有整数对 (w, h) 分别代表信封宽度和高度。一个信封的宽高均大于另一个信封时可以放下另一个信封。
 * 求最大的信封嵌套层数。
 */
public class MaxEnvelopes {

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{
                {1,2},
                {3,4},
                {5,6},
                {6,5},
                {7,8}
        };
        maxEnvelopes(envelopes);
        System.out.print("the result is "+ ans);
    }
    public static int maxEnvelopes(int[][] envelopes){
        if (null == envelopes || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }
        Arrays.sort(envelopes, Comparator.comparing(a -> a[0]));
        dfs(envelopes, 0, 0);
        return ans;
    }

    static int ans = 0;
    private static void dfs(int[][] envelopes, int x, int num){
        ans = Math.max(num, ans);

        for (int i = x; i < envelopes.length; i++) {
            if (x == 0||(envelopes[i][0] > envelopes[x - 1][0] && envelopes[i][1] > envelopes[x -1][1])){
                dfs(envelopes, i + 1, num+1);
            }
        }
    }

}
