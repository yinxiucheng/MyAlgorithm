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
public class SixDegrees2 {

    public static void main(String[] args) {
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node1);
        node2.neighbors.add(node4);

        node3.neighbors.add(node1);
        node3.neighbors.add(node4);

        node4.neighbors.add(node2);
        node4.neighbors.add(node3);
        List<UndirectedGraphNode> graphNodes = new ArrayList<>();
        graphNodes.add(node1);
        graphNodes.add(node2);
        graphNodes.add(node3);
        graphNodes.add(node4);
        int result = sixDegrees(graphNodes, node1, node4);
        System.out.println("The result is " + result);

    }

    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public static int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (null == graph || graph.size() == 0 || null == s || null == t){
            return -1;
        }
        Queue<UndirectedGraphNode> forwardQueue = new LinkedList<>();
        Queue<UndirectedGraphNode> backwardQueue = new LinkedList<>();
        Set<UndirectedGraphNode> forwardVisited = new HashSet<>();
        Set<UndirectedGraphNode> backwardVisited = new HashSet<>();
        forwardQueue.offer(s);
        backwardQueue.offer(t);
        forwardVisited.add(s);
        backwardVisited.add(t);
        int degree = 0;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()){
            degree++;
            if (enterQueue(forwardQueue, forwardVisited, backwardVisited)){
                return degree;
            }
            degree++;
            if (enterQueue(backwardQueue, backwardVisited, forwardVisited)){
                return degree;
            }
        }
        return -1;
    }

    private static boolean enterQueue(Queue<UndirectedGraphNode> queue, Set<UndirectedGraphNode> visited, Set<UndirectedGraphNode> oppositeVisited){
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            UndirectedGraphNode node = queue.poll();
            for (UndirectedGraphNode neighbor: node.neighbors) {
                if (oppositeVisited.contains(neighbor)){
                    return true;
                }
                if (visited.contains(neighbor)){
                    continue;
                }
                queue.offer(neighbor);
                visited.add(neighbor);
            }
        }
        return false;
    }
}
