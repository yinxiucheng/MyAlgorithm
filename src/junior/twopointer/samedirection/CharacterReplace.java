package junior.twopointer.samedirection;

import java.util.HashMap;

/**
 * https://www.lintcode.com/problem/1246/description
 *
 * 给定一个仅包含大写英文字母的字符串，您可以将字符串中的任何一个字母替换为的另一个字母，最多替换k次。 执行上述操作后，找到最长的，只含有同一字母的子字符串的长度。
 */
public class CharacterReplace {

    /**
     * @param s: a string
     * @param k: a integer
     * @return: return a integer
     */
    public int characterReplacement(String s, int k) {
        if (null == s || s.length() == 0){
            return 0;
        }
        if (k == 0){
            return -1;
        }
        char[] chars = s.toCharArray();
        int j = 0, maxFrq = 0, answer = 0;
        HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            while (j < chars.length && j - i - maxFrq <= k) {
                int count = counter.getOrDefault(chars[j], 0) + 1;
                counter.put(chars[j], count);
                maxFrq = Math.max(maxFrq, count);
                j++;
            }

            if (j - i - maxFrq > k) {
                answer = Math.max(answer, j - 1 - i);
            } else {
                answer = Math.max(answer, j - i);
            }
            int count = counter.getOrDefault(chars[i], 0) - 1;
            counter.put(chars[i] , count);
            maxFrq = getMaxFrq(counter);
        }
        return answer;
    }

    private int getMaxFrq(HashMap<Character, Integer> counter){
        int maxFre = 0;
        for (Character c: counter.keySet()) {
           int count =  counter.getOrDefault(c, 0);
           maxFre = Math.max(maxFre, count);
        }
        return maxFre;

    }
}
