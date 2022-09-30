package senior.towpoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 1375 · 至少K个不同字符的子串
 *
 * https://www.lintcode.com/problem/1375/
 *
 * 描述
 * 给定一个仅包含小写字母的字符串 S.
 *
 * 返回 S 中至少包含 k 个不同字符的子串的数量.
 *
 *
 * 输入: S = "abcabcabcabc", k = 3
 * 输出: 55
 * 解释: 任意长度不小于 3 的子串都含有 a, b, c 这三个字符.
 *     比如,长度为 3 的子串共有 10 个, "abc", "bca", "cab" ... "abc"
 *     长度为 4 的子串共有 9 个, "abca", "bcab", "cabc" ... "cabc"
 *     ...
 *     长度为 12 的子串有 1 个, 就是 S 本身.
 *     所以答案是 1 + 2 + ... + 10 = 55.
 *
 */
public class KDistinctCharacters {

    public long kDistinctCharacters(String s, int k) {
        int ans = 0;
        int j = 0;
        Map<Character, Integer> charToCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && charToCount.size() < k){
                charToCount.put(s.charAt(j), charToCount.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }

            if (charToCount.size() == k){
                ans += s.length() - j + 1;
            }
            charToCount.put(s.charAt(i), charToCount.getOrDefault(s.charAt(i), 0) - 1);
            if (charToCount.getOrDefault(s.charAt(i), 0) <= 0){
                charToCount.remove(s.charAt(i));
            }
        }
        return ans;
    }
}
