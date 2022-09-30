package junior.dfs;


import java.util.*;

/**
 * https://www.lintcode.com/problem/121/?fromId=161&_from=collection
 *
 * 描述
 * 给出两个单词（start和end）和一个字典，找出所有从start到end的最短转换序列。
 *
 * 变换规则如下：
 *
 * 每次只能改变一个字母。
 * 变换过程中的中间单词必须在字典中出现。
 */
public class FindLadders {

    /**
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     *          we will sort your return value in output
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        dict.add(start);
        dict.add(end);
        List<List<String>> results = new ArrayList<>();
        Map<String, Set<String>> graph = createGraph(dict);
        Map<String, Integer> distance = bfs(end, graph);
        List<String> path = new ArrayList<>();
        path.add(start);
        dfs(start, end, path, distance, graph, results);
        return results;
    }

    //返回每个点到 end的最短路径值。
    private Map<String, Integer> bfs(String end, Map<String, Set<String>> graph){
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        Map<String, Integer> distance = new HashMap<>();
        distance.put(end, 0);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, graph)) {
                    if (!distance.containsKey(nextWord)){
                        distance.put(nextWord, distance.get(word) + 1);
                        queue.offer(nextWord);
                    }
                }
            }
        }
        return distance;
    }

    //深度遍历
    private void dfs(String current, String end, List<String> path,Map<String, Integer> distance, Map<String, Set<String>> graph, List<List<String>> results){
        if (current.equals(end)){
            results.add(new ArrayList<>(path));
            return;
        }
        for (String nextWord: getNextWords(current, graph)){
            if (distance.get(nextWord) != distance.get(current) - 1){
                continue;
            }
            path.add(nextWord);
            dfs(nextWord, end, path, distance, graph, results);
            path.remove(path.size() - 1);
        }
    }

    //构图
    private Map<String, Set<String>> createGraph(Set<String> dict) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (String word : dict) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + "%" + word.substring(i + 1);
                if (graph.containsKey(key)){
                    graph.get(key).add(word);
                }else {
                    graph.put(key, new HashSet<>());
                    graph.get(key).add(word);
                }
            }
        }
        return graph;
    }

    //获取邻接边
    private List<String> getNextWords(String word, Map<String, Set<String>> graph){
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + "%" + word.substring(i+1);
            for (String nextWord: graph.get(key)) {
                if (!nextWords.contains(nextWord)){
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}
