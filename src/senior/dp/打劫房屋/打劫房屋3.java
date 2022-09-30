package senior.dp.打劫房屋;

import junior.datamodel.ListNode;
import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 535 · 打劫房屋 III
 *
 *
 *  树形DP。
 *
 */
public class 打劫房屋3 {

    public int houseRobber3(TreeNode root) {
        if (root == null){
            return 0;
        }
        int weight1 = dfs(root);
        int weight2 = dfs(root.left) + dfs(root.right);
        return Math.max(weight1, weight2);
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        List<TreeNode> grantSonList = getGrantSonList(root);
        if (grantSonList.isEmpty()){
            return root.val;
        }
        int result = root.val;
        for (TreeNode grandSon: grantSonList) {
            result += dfs(grandSon);
        }
        return result;
    }

    private List<TreeNode> getGrantSonList(TreeNode root){
        List<TreeNode> results = new ArrayList<>();
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;

        if (leftChild!= null){
            if (leftChild.left != null) results.add(leftChild.left);
            if (leftChild.right != null) results.add(leftChild.right);
        }

        if (rightChild != null){
            if (rightChild.left != null) results.add(rightChild.left);
            if (rightChild.right != null) results.add(rightChild.right);
        }
        return results;
    }
}
