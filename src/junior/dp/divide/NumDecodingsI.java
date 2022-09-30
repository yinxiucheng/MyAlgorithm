package junior.dp.divide;

/**
 * 676 · 解码方式 II
 *
 * 描述
 * 使用以下映射方式将 A-Z 的消息编码为数字:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 除此之外, 编码的字符串也可以包含字符 *, 它代表了 1 到 9 的数字中的其中一个.给出包含数字和字符 * 的编码消息, 返回所有解码方式的数量. 因为结果可能很大, 所以结果需要对 10^9 + 7 取模
 *
 */
public class NumDecodingsI {

    public static void main(String[] args) {
        String s = "*7";
        int result =  numDecodings(s);
        System.out.print("the result is "+ result);

    }
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public static int numDecodings(String s) {
        if (null == s || s.length() == 0){
            return 0;
        }
        int n = s.length();

        //dp state 前i个字符对应的解密方法总数。
        long MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;//方法数为1.
        if (s.charAt(0) == '0'){
            dp[1] = 0;
        }else if (s.charAt(0) == '*'){
            dp[1] = 9;
        }else {
            dp[1] = 1;
        }


        for (int i = 2; i <= n ; i++) {//这里求方法总数。
            String subStr1 = s.substring(i-1, i);
            if (isCode(subStr1) != 0){ // 1 * dp[i-1] 为这种情况下的 方法总数
                dp[i] = dp[i-1] * isCode(subStr1);
            }

            String subStr2 = s.substring(i-2, i);
            if (isCode(subStr2) != 0){// 1 * dp[i-2] + dp[i] (原来划分1个的方法总数) 两者求和。
                dp[i] += dp[i-2] * isCode(subStr2);
            }
            dp[i] %= MOD;
        }
        return (int)dp[n];
    }

    private static int isCode(String subStr) {
        if (subStr.length() == 1) {
            if (subStr.equals("0")) {
                return 0;
            } else if (subStr.equals("*")) {
                return 9;
            } else {
                return 1;
            }
        } else {
            if (subStr.equals("**")) {
                int num = 26 - 11;//20不能取， 所以一共15种。
                return num;
            } else if (subStr.endsWith("*")) {
                int digit = subStr.charAt(0) - '0';
                if (digit > 2 || digit == 0) {
                    return 0;
                } else if (digit == 2) {
                    int sum = 9 - 3;
                    return sum;
                } else {
                    return 9;
                }
            } else if (subStr.startsWith("*")){
                // * 匹配  1、2. endDigit 表示个位数。
                int endDigit = subStr.charAt(1) - '0';
                if (endDigit <= 6) {
                    return 2;
                } else {
                    return 1;
                }
            }else {
                int val = Integer.parseInt(subStr);
                if (val >= 10 && val <= 26) {
                    return 1;
                }
                return 0;
            }
        }
    }
}
