package junior.twopointer.closingoppsite;

/**
 *  https://www.lintcode.com/problem/891/
 *
 * 描述
 * 给一个非空字符串 s，你最多可以删除一个字符。判断是否可以把它变成回文串。
 *
 */
public class ValidPalindrome {
    /**
     * @param s: a string
     * @return: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        int start = 0 , end = s.length() - 1;
        while (start < end){
            if (s.charAt(start) != s.charAt(end)) break;
            start ++ ;
            end -- ;
        }
        if (start >= end) return true;

        return isPalindromeStr(s, start + 1, end) || isPalindromeStr(s, start, end - 1);
    }

    private boolean isPalindromeStr(String s, int start, int end){
        while (start < end){
            if (s.charAt(start) != s.charAt(end)) break;
            start ++ ;
            end -- ;
        }
        return s.charAt(start) == s.charAt(end);
    }


}
