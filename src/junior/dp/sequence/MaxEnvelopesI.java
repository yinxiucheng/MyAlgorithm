package junior.dp.sequence;

import java.util.Arrays;

/**
 * 602.俄罗斯套娃信封
 * https://www.lintcode.com/problem/602/solution?fromId=161&_from=collection
 *
 * 描述
 * 给一定数量的信封，带有整数对 (w, h) 分别代表信封宽度和高度。一个信封的宽高均大于另一个信封时可以放下另一个信封。
 * 求最大的信封嵌套层数。
 */
public class MaxEnvelopesI {

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        maxEnvelopes(envelopes);
    }

    public static int maxEnvelopes(int[][] envelopes){
        if (null == envelopes || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }
        Arrays.sort(envelopes, (arr1, arr2) -> {
            int diff = arr1[0] - arr2[0];
            if (diff == 0){
                diff = arr2[1] - arr1[1];
            }
            return diff;
        });

        int n = envelopes.length;

        // state 可以套的层数。
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;//装的自己。
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n ; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
