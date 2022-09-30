package senior.towpoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 386 · 最多有k个不同字符的最长子字符串
 *
 * https://www.lintcode.com/problem/386/
 *
 * 描述
 * 给定字符串S，找到最多有k个不同字符的最长子串T。
 *
 * 输入: S = "eceba" 并且 k = 3
 * 输出: 4
 * 解释: T = "eceb"
 */
public class LengthOfLongestSubstringKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> charToCount = new HashMap<>();

        int j = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            // charToCount.size() < k , Map里的字母数少于 K;
            //charToCount.getOrDefault(s.charAt(j), 0) > 0, s.charAt(j)已经在 map里有了，不会影响 charToCount 的size.
            while (j < s.length() && (charToCount.size() < k || charToCount.getOrDefault(s.charAt(j), 0) > 0)){
                charToCount.put(s.charAt(j), charToCount.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }

            if (charToCount.size() == k){
                maxLen = Math.max(maxLen, j - i);
            }
            charToCount.put(s.charAt(i), charToCount.getOrDefault(s.charAt(i), 0) - 1);
            if (charToCount.getOrDefault(s.charAt(i), 0) <= 0){
                charToCount.remove(s.charAt(i));
            }
        }
        return maxLen;
    }
}
