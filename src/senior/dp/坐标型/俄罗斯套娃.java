package senior.dp.坐标型;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://www.lintcode.com/problem/602/
 */
public class 俄罗斯套娃 {

    public int maxEnvelopes(int[][] envelopes) {
        if (null == envelopes || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = o1[0] - o2[0];
                if (diff == 0){
                    diff = o2[1] - o1[1];
                }
                return diff;
            }
        });

        int n = envelopes.length;

        int[] f = new int[n];
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
