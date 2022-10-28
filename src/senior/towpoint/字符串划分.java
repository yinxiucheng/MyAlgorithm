package senior.towpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 328 · 字符串划分
 *
 * https://www.lintcode.com/problem/328/
 *
 * 描述
 * 给出一个字符串，均为大写字母，将这个字符串划分成尽可能多的部分，使每种字母只会出现一个部分中。最后返回一个数组，这个数组包含每个部分的长度。
 *
 *
 */
public class 字符串划分 {

    public List<Integer> splitString(String s) {
        List<Integer> results = new ArrayList<>();
        Map<Character, Integer> lastPosition = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            lastPosition.put(c, i);
        }

        int i=0, j = 0;
        while (i < s.length()){
            int start = i;
            j = lastPosition.get(s.charAt(i));
            while (j < s.length() && i < j){
                j = Math.max(j, lastPosition.get(s.charAt(i)));
                i++;
            }
            results.add(j - start + 1);
            i++;
        }
        return results;
    }
}
