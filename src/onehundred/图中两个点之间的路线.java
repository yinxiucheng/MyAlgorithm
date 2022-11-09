package onehundred;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 176 · 图中两个点之间的路线
 * https://www.lintcode.com/problem/176/?fromId=164&_from=collection
 *
 *
 */
public class 图中两个点之间的路线 {

    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()){
            DirectedGraphNode cur = queue.poll();
            if (cur == t){
                return true;
            }
            for (DirectedGraphNode neighbor: cur.neighbors) {
                if (visited.contains(neighbor)){
                    continue;
                }
                queue.offer(neighbor);
                visited.add(neighbor);
                if (neighbor == t){
                    return true;
                }
            }
        }
        return false;
    }

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
}
