package junior.bfs.shortpath;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/120/description
 *
 * 描述
 * 给出两个单词（start和end）和一个字典，找出从start到end的最短转换序列，输出最短序列的长度。
 *
 * 变换规则如下：
 *
 * 每次只能改变一个字母。
 * 变换过程中的中间单词必须在字典中出现。(起始单词和结束单词不需要出现在字典中)
 */
public class LadderLength {

    /**
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int distance = 0;
        Set<String> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()){
            distance ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (end.equals(word)) {
                    return distance;
                }
                for (String nextWord: getNextWord(word)) {
                    if (!dict.contains(nextWord) || visited.contains(nextWord)){
                        continue;
                    }
                    queue.offer(nextWord);
                    visited.add(nextWord);
                }
            }
        }
        return 0;
    }

    char[] alphaBeta = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
    'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private Set<String> getNextWord(String word){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String endFix = word.substring(i+1);
            char c = word.charAt(i);
            for (char replace: alphaBeta){
                if (replace == c){
                    continue;
                }
                String str= prefix + replace + endFix;
                set.add(str);
            }
        }
        return set;
    }
}
