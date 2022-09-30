package junior.dp.divide;

/**
 * 512 · 解码方法
 *
 * 划分型 DP
 *
 * https://www.lintcode.com/problem/512/
 *
 * 描述
 * 有一个消息包含A-Z通过以下规则编码
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 现在给你一个加密过后的消息，问有几种解码的方式
 */
public class NumDecodings {

    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (null == s || s.length() == 0){
            return 0;
        }
        int n = s.length();

        //dp state 前i个字符对应的解密方法总数。
        int[] dp = new int[n + 1];
        dp[0] = 1;//方法数为1.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n ; i++) {//这里求方法总数。
            String subStr1 = s.substring(i-1, i);
            if (isCode(subStr1)){ // 1 * dp[i-1] 为这种情况下的 方法总数
                dp[i] = dp[i-1];
            }

            String subStr2 = s.substring(i-2, i);
            if (isCode(subStr2)){// 1 * dp[i-2] + dp[i] (原来划分1个的方法总数) 两者求和。
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    private boolean isCode(String subStr){
        if (subStr.length() == 1){
            if (subStr.equals("0")){
                return false;
            }
            return true;
        }else {
           int val =  Integer.parseInt(subStr);
           if (val >= 10 && val <= 26){
               return true;
           }
           return false;
        }
    }
}
