package junior.dp.rangedp;

/**
 * 200 · 最长回文子串 (枚举法)
 *
 * https://www.lintcode.com/problem/200/description
 *
 * 描述
 * 给出一个字符串（假设长度最长为1000），求出它的最长回文子串，你可以假定只有一个满足条件的最长回文串。
 *
 *
 */
public class LongestPalindromeI {

    public String longestPalindrome(String s) {
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

    public Pair expandAroundCenter(String s, int left, int right) {
        int len = s.length();
        for (; isValid(left, right, len); left--, right++) {
            if (s.charAt(left) != s.charAt(right)) break;
        }
        left ++;
        right --;
        return new Pair(right - left + 1, left, right);
    }

    private  boolean isValid(int start, int end, int len){
        return start >= 0 && end < len;
    }

    class Pair{
        private int len;
        private int start;
        private int end;

        private Pair(int len, int start, int end){
            this.len = len;
            this.start = start;
            this.end = end;
        }
    }
}
