package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

import java.util.*;

/**
 * 1588 · 所有可能的满二叉树
 *
 * https://www.lintcode.com/problem/1588/solution/49986?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 *
 *
 */
public class 所有的满二叉树 {

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2==0){
            return new ArrayList<>();
        }
        Map<Integer, List<TreeNode>> dp = new HashMap<>();

        return findFBT(n, dp);
    }

    private List<TreeNode> findFBT(int n, Map<Integer, List<TreeNode>> dp){
        if (n == 0){
            return new ArrayList<>();
        }else if (n==1){
            return Collections.singletonList(new TreeNode(0));
        } else if (dp.containsKey(n)) {
           return dp.get(n);
        }

        List<TreeNode> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<TreeNode> leftNodes = findFBT(i, dp);
            List<TreeNode> rightNodes = findFBT(n-i-1, dp);
            for (TreeNode left: leftNodes) {
                for (TreeNode right: rightNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        dp.put(n, ans);
        return ans;
    }
}
