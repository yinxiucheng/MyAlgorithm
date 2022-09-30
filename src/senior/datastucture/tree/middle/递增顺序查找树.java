package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1744 · 递增顺序查找树
 *
 * https://www.lintcode.com/problem/1744/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 * 描述
 * 给定一个二叉排序树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 */
public class 递增顺序查找树 {

    public TreeNode increasingBST(TreeNode root) {
       return inorderTraversal(root);
    }

    public TreeNode inorderTraversal(TreeNode root) {
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 0));
        TreeNode dummy = new TreeNode(-1);
        dummy.right = root;
        TreeNode preNode = dummy;
        while (!stack.isEmpty()){
            State curState = stack.pop();
            TreeNode curNode = curState.treeNode;
            if (curNode == null){
                continue;
            }
            if (curState.count == 0){
                stack.push(new State(curNode, 3));
                stack.push(new State(curNode.right, 0));
                stack.push(new State(curNode, 2));
                stack.push(new State(curNode.left, 0));
                stack.push(new State(curNode, 1));
            }
            if (curState.count == 2){
                preNode.right = curNode;
                preNode = curNode;
                preNode.left = null;
            }
        }
        return dummy.right;
    }

    class State {
        int count;
        TreeNode treeNode;
        public State(TreeNode node, int count){
            this.treeNode = node;
            this.count = count;
        }
    }
}
