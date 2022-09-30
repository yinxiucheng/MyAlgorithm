package senior.datastucture.unionfind;

import java.util.*;

/**
 * https://www.lintcode.com/problem/432/?fromId=178&_from=collection
 * 432 · 找出有向图中的弱连通分量
 */
public class 找出有向图中的弱连通分量 {

    class DirectedGraphNode {
        int label;
        List<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        Set<Integer> set = new HashSet<>();

        for (DirectedGraphNode node: nodes) {
            set.add(node.label);
            for (DirectedGraphNode neighbor : node.neighbors) {
                set.add(neighbor.label);
            }
        }

        UFS unionFind = new UFS(set);
        for (DirectedGraphNode node: nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                unionFind.union(node.label, neighbor.label);
            }
        }

        Map<Integer, Set<Integer>> graph = unionFind.buildGraph();
        List<List<Integer>> results = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            List<Integer> list = new ArrayList<>(entry.getValue());
            Collections.sort(list);
            results.add(list);
        }
        return results;
    }

    class UFS{

        Map<Integer, Integer> father;
        public UFS(Set<Integer> set){
           father = new HashMap<>();
            for (Integer item: set) {
                father.put(item, item);
            }
        }

        public void union(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b){
                father.put(root_a, root_b);
            }
        }

        public Map<Integer, Set<Integer>> buildGraph(){
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry: father.entrySet()) {
                Set<Integer> path = new HashSet<>();
                int cur = entry.getKey();
                while (cur != father.get(cur)){
                    path.add(cur);
                    cur = father.get(cur);
                }
                path.add(cur);
                Set<Integer> set = graph.getOrDefault(cur, new HashSet<>());
                set.addAll(path);
                graph.put(cur, set);
            }
            return graph;
        }

        public int find(int x){
            int root = x, fx;
            while (root != father.get(root)){
                root = father.get(root);
            }

            while (x != root){
                fx = father.get(x);
                father.put(x, root);
                x = fx;
            }
            return root;
        }

    }

}
