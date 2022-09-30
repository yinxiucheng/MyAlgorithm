package junior.datastructure;

import java.util.*;

/**
 * https://www.lintcode.com/problem/171/?fromId=161&_from=collection
 *
 * 描述
 * 给出一个字符串数组S，找到其中所有的乱序字符串(Anagram)。如果一个字符串是乱序字符串，那么他存在一个字母集合相同，但顺序不同的字符串也在S中。
 */
public class Anagrams {

    public static void main(String[] args) {
        String[] test = new String[]{"",""};
        List<String> list = anagrams(test);
    }
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     *          we will sort your return value in output
     */
    public static List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(strs[i]);
        }


        for (List<String> strList: map.values()) {
            if (strList.size() > 1){
                result.addAll(strList);
            }
        }
        return result;
    }
}
