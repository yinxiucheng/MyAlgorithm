package junior.bfs.shortpath;

import java.util.*;

/**
 * 624 · 移除子串
 *
 * https://www.lintcode.com/problem/624/solution/23726
 *
 *
 */
public class MinLengthI {

    public int minLength(String s, Set<String> dict) {

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(s);
        set.add(s);

        int min = s.length();

        while (!queue.isEmpty()){
            int size = queue.size();
            //遍历每一层。
            for (int i = 0; i < size; i++) {
               String curStr =  queue.poll();
                for (String word: dict) {
                    int found = curStr.indexOf(word);
                    while (found != -1){
                        //注意后面是 found+word.length() 的值。
                        String newStr = curStr.substring(0, found) + curStr.substring(found+word.length());
                        if (!set.contains(newStr)){
                            min = Math.min(min, newStr.length());
                            queue.offer(newStr);
                            set.add(newStr);
                        }
                        found = curStr.indexOf(word, found + 1);
                    }
                }
            }
        }
        return min;
    }
}
