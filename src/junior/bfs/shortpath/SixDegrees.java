package junior.bfs.shortpath;

import junior.datamodel.UndirectedGraphNode;

import java.util.*;

/**
 * https://www.lintcode.com/problem/531/?fromId=161&_from=collection
 *
 * 描述
 * 六度分离是一个哲学问题，说的是每个人每个东西可以通过六步或者更少的步数建立联系。
 *
 * 现在给你一个友谊关系，查询两个人可以通过几步相连，如果不相连返回 -1
 */
public class SixDegrees {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (null == graph || graph.size() == 0 || null == s || null == t){
            return -1;
        }
        Queue<UndirectedGraphNode>  queue = new LinkedList<>();
        queue.offer(s);
        Set<UndirectedGraphNode> visited = new HashSet<>();
        int degree = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = queue.poll();
                if (node == t){
                    return degree;
                }
                for (UndirectedGraphNode neighbor: node.neighbors) {
                    if (visited.contains(neighbor)){
                        continue;
                    }
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            degree++;
        }
        return -1;
    }
}
