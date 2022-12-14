package junior.string;

/**
 * 给出一个包含大小写字母的字符串。求出由这些字母构成的最长的回文串的长度是多少。
 *
 * 数据是大小写敏感的，也就是说，"Aa" 并不会被认为是一个回文串。
 */
public class LongestPalindrome {

    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        int[] count = new int[128];
        for (int i = 0; i < count.length; i++) {
            int c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
