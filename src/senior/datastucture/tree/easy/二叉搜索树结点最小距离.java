package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1746 · 二叉搜索树结点最小距离
 *
 * https://www.lintcode.com/problem/1746/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 *
 * 描述
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 输入: root = {4,2,6,1,3}
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 */
public class 二叉搜索树结点最小距离 {

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midTravers(root, list);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            result = Math.min(result,  Math.abs(list.get(i+1) - list.get(i)));
        }
        return result;
    }

    public void midTravers(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        midTravers(root.left, list);
        list.add(root.val);
        midTravers(root.right, list);
    }
}
