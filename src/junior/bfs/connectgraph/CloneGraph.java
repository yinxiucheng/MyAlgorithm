package junior.bfs.connectgraph;

import junior.datamodel.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/137/description?fromId=161&_from=collection
 *
 */
public class CloneGraph {

    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (null == node){
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, new UndirectedGraphNode(node.label));

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode source = queue.poll();
                if (!visited.containsKey(source)){
                    visited.put(source, new UndirectedGraphNode(source.label));
                }
                UndirectedGraphNode newCopy = visited.get(source);
                for (UndirectedGraphNode neighbor: source.neighbors) {
                    if (!visited.containsKey(neighbor)){
                        UndirectedGraphNode neighborCopy =  new UndirectedGraphNode(neighbor.label);
                        visited.put(neighbor, neighborCopy);
                        queue.offer(neighbor);
                        newCopy.neighbors.add(neighborCopy);
                    }
                }
            }
        }
        return visited.get(node);
    }

}
