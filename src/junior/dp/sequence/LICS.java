package junior.dp.sequence;

/**
 * 397 · 最长上升连续子序列
 *
 * https://www.lintcode.com/problem/397/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。
 * （最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 *
 *  区别是连续。
 */
public class LICS {

    public static void main(String[] args) {
        int[] a = new int[]{10};
        int result = longestIncreasingContinuousSubsequence(a);
        System.out.print("the result is " + result);
    }
    //注意 连续升，连续奖都可以。
    public static int longestIncreasingContinuousSubsequence(int[] a) {
        if (null == a || a.length == 0){
            return 0;
        }
        int n = a.length;
        //# dp index 第num[index] 最长上升子序列 的length = dp[index]
        //ascending
        //descending
        int[] dpIncr = new int[n];
        int[] dpDesc = new int[n];
        for (int i = 0; i < n; i++) {
            dpIncr[i] = 1;
            dpDesc[i] = 1;
        }

        for (int i = 1; i < n ; i++) {
            if (a[i] > a[i-1]){
                dpIncr[i] = dpIncr[i-1] + 1;
            }
            if (a[i] < a[i-1]){
                dpDesc[i] = dpDesc[i - 1] + 1;
            }
        }
        int longest = 0;
        for (int i = 0; i < n; i++) {
            longest = Math.max(longest, Math.max(dpIncr[i], dpDesc[i]));
        }
        return longest;
    }
}
