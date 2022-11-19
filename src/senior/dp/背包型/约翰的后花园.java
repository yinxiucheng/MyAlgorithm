package senior.dp.背包型;

/**
 * 749 · 约翰的后花园
 *
 * https://www.lintcode.com/course/24/learn/749?chapterId=142&sectionId=2316&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A24%22%7D&ac=false
 *
 * 描述
 * 约翰想在他家后面的空地上建一个后花园，现在有两种砖，一种3 dm的高度，7 dm的高度。约翰想围成x dm的墙。如果约翰能做到，输出YES，否则输出NO。
 *
 */
public class 约翰的后花园 {

    public String isBuild(int x) {
        int[] builds = {3, 7};
        boolean[][] dp = new boolean[3][x+1];//dp[i][j] 表示前i种砖，建高度为j 是否可以。

        dp[0][0] = true;
        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j <= x ; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= builds[i-1]){
                    dp[i][j] = dp[i][j] || dp[i][j-builds[i-1]];
                }
            }
        }
        return dp[2][x]? "YES":"NO";
    }


}
