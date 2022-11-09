package senior.datastucture.tree.ntree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/1530/
 *
 */
public class 将N叉树编码为二叉树 {

    public TreeNode encode(UndirectedGraphNode root) {
        if (root == null) return null;
        TreeNode treeRoot = new TreeNode(root.label);
        if (root.neighbors.size() > 0){
            treeRoot.left = encode(root.neighbors.get(0));
        }

        TreeNode cur = treeRoot.left;
        for (int i = 1; i < root.neighbors.size(); i++){
            cur.right = encode(root.neighbors.get(i));
            cur = cur.right;
        }
        return treeRoot;
    }

    public UndirectedGraphNode decode(TreeNode root) {
        if (root == null) return null;
        UndirectedGraphNode uRoot = new UndirectedGraphNode(root.val);
        TreeNode cur = root.left;
        while (cur != null){
            uRoot.neighbors.add(decode(cur));
            cur = cur.right;
        }
        return uRoot;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }


    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


}
