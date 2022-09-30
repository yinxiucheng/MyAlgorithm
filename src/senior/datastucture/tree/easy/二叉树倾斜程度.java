package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/1172/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 */
public class 二叉树倾斜程度 {


    int ans = 0;
    public  int findTilt(TreeNode root) {
       dfs(root);
       return ans;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        ans += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

}
