package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1783 · 二叉树的后序遍历
 */
public class 二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        traversalHelper(root, results);
        return results;
    }

    private void traversalHelper(TreeNode root, List<Integer> results){
        if (root == null){
            return;
        }
        traversalHelper(root.left, results);
        traversalHelper(root.right, results);
        results.add(root.val);
    }
}
