package senior.dp.背包型;


/**
 * 会议室4
 *
 * https://www.lintcode.com/problem/300/?showListFe=true&page=1&problemTypeId=2&tagIds=400&pageSize=50
 *
 * Not Pass.
 */
public class 会议室4 {

    public int maxValue(int[][] meeting, int[] value) {
        // write your code here
        int len = meeting.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;

        for (int i = 1; i <= len ; i++) {
            dp[i] = dp[i - 1];
            if (i > 1) {
                int[] meetingCur = meeting[i - 1];
                int[] meetingPre = meeting[i - 2];
                if (meetingCur[0] >= meetingPre[1]) {
                    dp[i] = Math.max(dp[i], dp[i - 1] + value[i - 1]);
                }
            }
        }
        return dp[len];
    }

}
