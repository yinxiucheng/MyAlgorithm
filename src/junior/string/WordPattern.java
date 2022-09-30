package junior.string;

import java.util.*;

/**
 * https://www.lintcode.com/problem/828/description
 *
 * 描述
 * 给定一个模式串pattern和一个字符串str，请问str和pattern是否遵循相同的模式。
 * 这里遵循模式指的是一个完全匹配，即在pattern中的每个不同的字母和str中每个非空的单词之间有一个双向映射的模式对应。
 */
public class WordPattern {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public static boolean wordPattern(String pattern, String teststr) {
        // write your code here
        String[] subStrs = teststr.split(" ");
        if (pattern.length() != subStrs.length){
            return false;
        }
        Map<String, Character> patternMap = new HashMap<>();
        int size = subStrs.length;
        for (int i = 0; i < size; i++) {
            String str = subStrs[i];
            char c = pattern.charAt(i);
            if (!patternMap.containsKey(str)){
                patternMap.put(str, c);
            }else {
                char compare = patternMap.get(str);
                if (c != compare){
                    return false;
                }
            }
            if (!checkUnitMap(patternMap)){
                return false;
            }
        }
        return true;
    }
    private static boolean checkUnitMap(Map<String, Character> map){
        Set<Character> set = new HashSet<>();
        for (Character c: map.values()) {
            set.add(c);
        }
        return set.size() == map.size();
    }

    public static void main(String[] args) {
        boolean res = wordPattern("abba", "dog dog dog dog");
    }
}
