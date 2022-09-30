package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.Stack;

/**
 * 1137 · 从二叉树构建字符串
 *
 * https://www.lintcode.com/problem/1137/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 */
public class 从二叉树构建字符串 {

    public String tree2str(TreeNode root) {
        if (null == root){
            return "()";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(root.val);
        boolean hasLeft = false;
        if (root.left != null){
            hasLeft = true;
            builder.append("(").append(tree2str(root.left)).append(")");
        }

        if (root.right != null){
            if (!hasLeft) builder.append("()");
            builder.append("(").append(tree2str(root.right)).append(")");
        }
        return builder.toString();
    }

}
