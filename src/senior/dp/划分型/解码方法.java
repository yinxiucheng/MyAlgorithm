package senior.dp.划分型;

/**
 * 512 · 解码方法
 *
 * https://www.lintcode.com/course/42/learn/512?chapterId=304&sectionId=1781&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以被解码为 AB (1 2) 或 L (12).
 *
 */
public class 解码方法 {

    public int numDecodings(String str) {
        char[] charArray = str.toCharArray();
        int len = charArray.length;
        if (len == 0){
            return 0;
        }
        //dp[i] 表示的是前i个字符解码方式 Count。
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len ; i++) {
            dp[i] = 0;
            if (charArray[i - 1] != '0'){
                dp[i] += dp[i-1];
            }

            if (i > 1 && (charArray[i-2] == '1' || charArray[i-2] == '2' &&  charArray[i-1] <= '6')){
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
}
