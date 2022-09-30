package senior.towpoint;

import java.util.HashMap;

/**
 * 384 · 最长无重复字符的子串
 *
 * https://www.lintcode.com/problem/384/
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 最长子串是 "abc".
 *
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charToCount = new HashMap<>();
        int j = 0;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !charToCount.containsKey(s.charAt(j))){
                charToCount.put(s.charAt(j) , 1);
                j++;
            }

            if (charToCount.containsKey(s.charAt(j))){
                maxLen = Math.max(maxLen, j - i);
            }

            charToCount.put(s.charAt(i), charToCount.get(s.charAt(i)) - 1);
            if (charToCount.get(s.charAt(i)) == 0){
                charToCount.remove(s.charAt(i));
            }
        }
        return maxLen == Integer.MIN_VALUE ? -1 : maxLen;
    }

}
