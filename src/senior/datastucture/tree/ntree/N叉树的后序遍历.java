package senior.datastucture.tree.ntree;

import java.util.ArrayList;
import java.util.List;

public class N叉树的后序遍历 {

    public List<Integer> postorder(UndirectedGraphNode root) {
        List<Integer> results = new ArrayList<>();
        for (UndirectedGraphNode neighbor:root.neighbors) {
            results.addAll(postorder(neighbor));
        }
        results.add(root.label);
        return results;
    }


    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}
