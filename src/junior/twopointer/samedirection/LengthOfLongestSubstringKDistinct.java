package junior.twopointer.samedirection;

import java.util.HashMap;
import java.util.Map;

/**
 * 386 · 最多有k个不同字符的最长子字符串
 *
 * 描述
 * 给定字符串S，找到最多有k个不同字符的最长子串T。
 *
 * 样例
 * 样例 1:
 *
 * 输入: S = "eceba" 并且 k = 3
 * 输出: 4
 * 解释: T = "eceb"
 *
 *
 * 样例 2:
 *
 * 输入: S = "WORLD" 并且 k = 4
 * 输出: 4
 * 解释: T = "WORL" 或 "ORLD"
 */
public class LengthOfLongestSubstringKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (null == s || s.length() == 0 ||  k == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int i, j = 0,  ans = 0;
        map.put(s.charAt(0), map.getOrDefault(s.charAt(0), 0) + 1);
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map.size() <= k) {
                j++;
                if (j < s.length()){
                    //将j位置的字符出现次数放入到Map中。
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                }
            }
            if (j < s.length()) {
                ans = Math.max(ans, j - i);
                //进入到下次 i++ 的for 循环，减去 i 对应字符出现的次数。
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if (map.getOrDefault(s.charAt(i), 0) == 0) {
                    map.remove(s.charAt(i));
                }
            }else {
                break;
            }
        }
        return Math.max(ans, j - i);
    }
}
