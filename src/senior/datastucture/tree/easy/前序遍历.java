package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            list.add(curNode.val);
            if (curNode.right != null){
                stack.push(curNode.right);
            }
            if (curNode.left != null){
                stack.push(curNode.left);
            }
        }
        return list;
    }
}
