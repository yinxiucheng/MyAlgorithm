package junior.bfs.topsort;

import java.util.*;

/**
 * 605 · 序列重构
 *
 * 描述
 * 判断是否序列 org 能唯一地由 seqs重构得出. org是一个由从1到n的正整数排列而成的序列 1≤n≤10^4
 *  。 重构表示组合成seqs的一个最短的父序列 (意思是，一个最短的序列使得所有 seqs里的序列都是它的子序列).
 * 判断是否有且仅有一个能从 seqs重构出来的序列，并且这个序列是org。
 *
 *
 */
public class SequenceReconstruction {

    public static void main(String[] args) {
        int[] org = {1,2, 3};
        int[][] seqs = {{1,2},{1, 3},{2, 3}};
        boolean result = sequenceReconstruction(org, seqs);

    }
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public static boolean sequenceReconstruction(int[] org, int[][] seqs) {
       Map<Integer, List<Integer>> graph = buildGraph(seqs);
       Map<Integer, Integer> indegree = getInDegree(graph);
       List<Integer> topSort = topSort(graph, indegree);
       if (topSort != null) {
           for (int i = 0; i < topSort.size(); i++) {
               if (topSort.get(i) != org[i]) {
                   return false;
               }
           }
       }else {
           return true;
       }

       return true;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] seqs){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] seq: seqs) {
            for (int i = 0; i < seq.length; i++) {
                if (!graph.containsKey(seq[i])){
                    graph.put(seq[i], new ArrayList<>());
                }
            }
        }

        for (int[] seq: seqs) {
            for (int i = 1; i < seq.length ; i++) {
                graph.get(seq[i-1]).add(seq[i]);
            }
        }
        return graph;
    }

    private static Map<Integer, Integer>  getInDegree(Map<Integer, List<Integer>> graph){
        Map<Integer, Integer> indegree = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
            Integer curPoint = entry.getKey();
            indegree.put(curPoint, indegree.getOrDefault(curPoint, 0));
            for (Integer neighbor: graph.get(curPoint)) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }
        return indegree;
    }

    private static  List<Integer> topSort(Map<Integer, List<Integer>> graph, Map<Integer, Integer> indegree){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topSort = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            int curPoint = entry.getKey();
            if (indegree.get(curPoint) == 0){
                queue.offer(curPoint);
                topSort.add(curPoint);
            }
        }

        while (!queue.isEmpty()){
            if (queue.size() > 1){
                return null;
            }
            Integer curPoint = queue.poll();
            for (Integer neighbor: graph.get(curPoint)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                    topSort.add(neighbor);
                }
            }
        }
        if (topSort.size() == graph.size()){
            return topSort;
        }
        return null;
    }
}
