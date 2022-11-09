package senior.datastucture.tree.ntree;

import java.util.ArrayList;
import java.util.List;

public class N叉树的前序遍历 {

    public List<Integer> preorder(UndirectedGraphNode root) {
        List<Integer> results = new ArrayList<>();
        results.add(root.label);
        for (UndirectedGraphNode neighbor: root.neighbors) {
            results.addAll(preorder(neighbor));
        }
        return results;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
