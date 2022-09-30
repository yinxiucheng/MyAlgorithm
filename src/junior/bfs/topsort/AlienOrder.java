package junior.bfs.topsort;

import java.util.*;

/**
 * 892 · 外星人字典
 *
 * https://www.lintcode.com/problem/892/
 *
 * 描述
 * 有一种新的使用拉丁字母的外来语言。但是，你不知道字母之间的顺序。你会从词典中收到一个非空的单词列表，
 * 其中的单词在这种新语言的规则下按字典顺序排序。请推导出这种语言的字母顺序。
 *
 */
public class AlienOrder {

    public static void main(String[] args) {
        String[] words = {"zy", "zx"};
        String result = alienOrder(words);
        System.out.println("the result is " + result);
    }

    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = buildGraph(words);
        if (graph == null){
            return "";
        }
        Map<Character, Integer> indegree = computeIndegree(graph);
        String topSortStr = topSort(graph, indegree);
        return topSortStr;
    }

    private static String topSort(Map<Character, Set<Character>> graph, Map<Character, Integer> indegree){
        StringBuffer buffer = new StringBuffer();
        //记住这里要用 PriorityQueue，这样出来的就是 字典排序了。
        Queue<Character> queue = new PriorityQueue<>();

        for (Character c:indegree.keySet()) {
            if (indegree.get(c) == 0){
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()){
            Character c = queue.poll();
            buffer.append(c);
            for (Character neighbor: graph.get(c)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
            }
        }
        if (buffer.length() != graph.size()){
            return "";
        }
        return buffer.toString();
    }

    private static Map<Character, Integer> computeIndegree(Map<Character, Set<Character>> graph){
        Map<Character, Integer> indegree = new HashMap<>();
        for (Map.Entry<Character, Set<Character>> entry: graph.entrySet()) {
            Character c = entry.getKey();
            indegree.put(c, indegree.getOrDefault(c, 0));
            for (Character neighbor: graph.get(c)) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }
        return indegree;
    }

    private static Map<Character, Set<Character>> buildGraph(String[] words){
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word: words) {
            int n = word.length();
            for (int i = 0; i < n; i++) {
                Character c = word.charAt(i);
                if (!graph.containsKey(c)){
                    graph.put(c, new HashSet<>());
                }
            }
        }
        for (int i = 1; i < words.length ; i++) {
            String preWord = words[i-1];
            String word = words[i];
            if (isPreStr(word, preWord)) {
                return null;
            }
            int pointIndex1 = 0;
            int pointIndex2 = 0;
            while (pointIndex1 < preWord.length() && pointIndex2 < word.length()){
                Character c1 = preWord.charAt(pointIndex1);
                Character c2 = word.charAt(pointIndex2);
                if (c1 != c2){
                    graph.get(c1).add(c2);
                    break;
                }
                pointIndex1++;
                pointIndex2++;
            }
        }
        return graph;
    }

    //如果 str 是 originalStr的前缀，则返回TRUE；否则FALSE；
    private static boolean isPreStr(String str, String originalStr){
        if (originalStr.length() < str.length()){
            return false;
        }
        int len = str.length();
        int i = 0;
        while (i < len){
            if (str.charAt(i) != originalStr.charAt(i)){
                return false;
            }
            i++;
        }
        return true;
    }
}
