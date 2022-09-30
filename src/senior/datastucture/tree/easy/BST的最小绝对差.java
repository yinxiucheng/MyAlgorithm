package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.Stack;

/**
 * https://www.lintcode.com/problem/1188/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class BST的最小绝对差 {

    public int getMinimumDifference(TreeNode root) {
        if (null == root){
            return 0;
        }
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 0));
        TreeNode preNode = null;
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()){
            State curState = stack.pop();
            TreeNode curNode = curState.node;
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
                if (preNode != null){
                   min = Math.min(min, Math.abs(preNode.val - curNode.val));
                }
                preNode = curNode;
            }
        }
        return min;
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
