package junior.string;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * leetCode 5;
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindromicSubString {

    public static void main(String[] args) {
        String test = "abcbe";
        String result = longestPalindrome(test);
        System.out.print("result : " + result);
    }

    public static String longestPalindrome1(String s) {
        int len = s.length();

        int maxLen = 0;//最长回文子串长度；
        String result = "";
        for (int center = 0; center < len; center++) {
            //奇数回文串
            for (int start = center, end = center; isValid(start, end, len); start--, end++) {
                if (s.charAt(start) != s.charAt(end)) break;
                int newLen = end - start + 1;
                if (newLen > maxLen) {
                    maxLen = newLen;
                    result = s.substring(start, end + 1);
                }
            }

            //偶数回文串
            for (int start = center, end = center + 1; isValid(start, end, len); start--, end++) {
                if (s.charAt(start) != s.charAt(end)) break;
                int newLen = end - start + 1;
                if (newLen > maxLen) {
                    maxLen = newLen;
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }

    private static   boolean isValid(int start, int end, int len){
        return start >= 0 && end < len;
    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        Pair ret = new Pair(0, 0, 0);
        for (int i = 0; i < s.length(); i++) {
            Pair pair1 = expandAroundCenter(s, i, i);
            Pair pair2 = expandAroundCenter(s, i, i + 1);
            if (pair1.len > ret.len) ret = pair1;
            if (pair2.len > ret.len) ret = pair2;
        }
        return s.substring(ret.start, ret.end + 1);
    }

    public static Pair expandAroundCenter(String s, int left, int right) {
        int len = s.length();
        for (; isValid(left, right, len); left--, right++) {
            if (s.charAt(left) != s.charAt(right)) break;
        }
        left ++;
        right --;
        return new Pair(right - left + 1, left, right);
    }
}
