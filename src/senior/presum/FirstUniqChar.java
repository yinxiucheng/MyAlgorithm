package senior.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * 646 · 第一个独特字符位置
 *
 * https://www.lintcode.com/problem/646/?fromId=178&_from=collection
 *
 * 给出一个字符串。找到字符串中第一个不重复的字符然后返回它的下标。如果不存在这样的字符，返回 -1。
 *
 */
public class FirstUniqChar {


    public int firstUniqChar(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charToCount.put(c, charToCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charToCount.get(c) == 1){
                return i;
            }
        }

        return -1;

    }



}
