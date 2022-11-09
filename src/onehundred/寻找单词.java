package onehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 寻找单词 {

    public static void main(String[] args) {
        String str = "bcogtadsjofisdhklasdj";
        List<String> dict = new ArrayList<>();
        dict.add("tag");
        findWords(str, dict);
    }

    public static List<String> findWords(String str, List<String> dict) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }

        List<String> results = new ArrayList<>();
        for (String word: dict) {
            int start = 0, i;
            boolean works = false;
            for (i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) break;// 没有在map里找到
                works = false;
                for (Integer index: map.get(c)) {
                    if (index >= start){// index >= start, 满足后继条件。
                        start = index + 1;
                        works = true;
                        break;
                    }
                }
                if (!works) break;
            }

            if (i == word.length()) results.add(word);
        }
        return results;
    }
}
