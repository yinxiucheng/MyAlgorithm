package senior.datastucture.unionfind;

import java.util.*;

/**
 * 591 · 连接图 III
 *
 * https://www.lintcode.com/course/7/learn/591?chapterId=43&sectionId=2052&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A7%22%7D&ac=false
 *
 */
public class ConnectingGraph3 {
    private int[] father = null;
    private int len = 0;
    public ConnectingGraph3(int n) {
        father = new int[n];
        len = n;
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            if (root_a < root_b) {
                father[root_a] = root_b;
            } else {
                father[root_b] = root_a;
            }
        }
    }

    public Map<Integer, Set<Integer>> buildGraph(){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int x = i;
            Set<Integer> path = new HashSet<>();
            while (x != father[x]){
                path.add(x);
                x = father[x];
            }
            path.add(x);//加上自己
            Set<Integer> set = graph.getOrDefault(x, new HashSet<>());
            set.addAll(path);
            graph.put(x, set);
        }
        return graph;
    }

    /**
     * @return: An integer
     */
    private int find(int x){
        int j = x, fx;
        while (j != father[j]){
            j = father[j];
        }
        while (x != j){
            fx = father[x];
            father[x] = j;
            x = fx;
        }
        return j;
    }
}
