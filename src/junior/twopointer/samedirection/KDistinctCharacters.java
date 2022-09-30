package junior.twopointer.samedirection;

import java.util.HashMap;
import java.util.Map;

/**
 * 1375 · 至少K个不同字符的子串
 *
 * https://www.lintcode.com/problem/1375/?fromId=161&_from=collection
 *
 */
public class KDistinctCharacters {

    public static void main(String[] args) {
        String test = "abcabcabca";
        long result = kDistinctCharacters(test, 4);
        System.out.print("the result is " + result);
    }
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public static long kDistinctCharacters(String s, int k) {
        if (null == s || s.length() == 0 || k == 0 || s.length() < k){
            return 0;
        }

        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map.size() < k){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j ++;
            }

            if (map.size() == k){
                ans += s.length() - j + 1;
            }

            int count = map.getOrDefault(s.charAt(i), 0) - 1;
            map.put(s.charAt(i), count);
            if (count <= 0){
                map.remove(s.charAt(i));
            }
        }
        return ans;
    }
}
