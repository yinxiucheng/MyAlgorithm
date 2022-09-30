package junior.binarytree;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/480/description?fromId=161&_from=collection
 *
 * 描述
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。
 *
 */
public class BinaryTreePaths {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     *          we will sort your return value in output
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (null == root){
            return result;
        }

        if (root.left == null && root.right == null){
            result.add(String.valueOf(root.val));
            return result;
        }

        if (null != root.left){
            List<String> leftResult = binaryTreePaths(root.left);
            for (String path: leftResult) {
                result.add(root.val + "->" + path);
            }
        }

        if (null != root.right){
            List<String> rightResult = binaryTreePaths(root.right);
            for (String path: rightResult) {
                result.add(root.val + "->" + path);
            }
        }
        return result;
    }


    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (null == root){
            return result;
        }
        List<TreeNode> path = new ArrayList<>();
        path.add(root);
        findPath(root, path, result);
        return result;
    }

    public void findPath(TreeNode node, List<TreeNode> path, List<String> result){
        if (node.left == null && node.right == null){
            String pathStr = createPath(path);
            result.add(pathStr);
        }
        if (null != node.left){
            path.add(node.left);
            findPath(node.left, path, result);
            path.remove(path.size() - 1);
        }

        if (null != node.right){
            path.add(node.right);
            findPath(node.right, path, result);
            path.remove(path.size() - 1);
        }
    }

    private String createPath(List<TreeNode> path){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            TreeNode node = path.get(i);
            if (i == path.size() - 1){
                builder.append(node.val);
            }else {
                builder.append(node.val).append("->");
            }
        }
        return builder.toString();
    }

}
