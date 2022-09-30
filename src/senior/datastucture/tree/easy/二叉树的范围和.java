package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.Stack;

/**
 * 1704 · 二叉搜索树的范围和
 *
 * https://www.lintcode.com/problem/1704/description?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 二叉树的范围和 {

    public int rangeSumBST(TreeNode root, int l, int r) {
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 0));
        int sum = 0;
        while (!stack.isEmpty()){
            State state = stack.pop();
            TreeNode curNode = state.node;
            if (curNode == null){
                continue;
            }
            if (state.count == 0){
                stack.push(new State(curNode, 3));
                stack.push(new State(curNode.right, 0));
                stack.push(new State(curNode, 2));
                stack.push(new State(curNode.left, 0));
                stack.push(new State(curNode, 1));
            }
            if (state.count == 2){
                if (curNode.val >= l && curNode.val <= r){
                    sum += curNode.val;
                }
            }
        }
        return sum;
    }

    class State{
        int count;
        TreeNode node;

        public State(TreeNode node, int count){
            this.node = node;
            this.count = count;
        }

    }
}
