package senior.presum;

import java.util.Arrays;

/**
 * 158 · 两个字符串是变位词
 *
 * https://www.lintcode.com/problem/158/?fromId=178&_from=collection
 *
 *
 */
public class Anagram {

    public boolean anagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }
}
