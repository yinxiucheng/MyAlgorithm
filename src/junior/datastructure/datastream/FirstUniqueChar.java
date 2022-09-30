package junior.datastructure.datastream;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/209/?fromId=161&_from=collection
 *
 * 描述
 * 给出一个字符串，找出第一个只出现一次的字符。假设只出现一次的字符数量大于等于1。
 */
public class FirstUniqueChar {

    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        HashMap<Character, Integer> charToTimes = new HashMap<>();
        if (null == str || str.length() == 0) {
            return ' ';
        }
        for (int i = 0; i < str.length(); i++) {
            if (charToTimes.containsKey(str.charAt(i))) {
                int times = charToTimes.get(str.charAt(i));
                charToTimes.put(str.charAt(i), times + 1);
            } else {
                charToTimes.put(str.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charToTimes.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
