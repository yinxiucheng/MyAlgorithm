package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.Stack;

/**
 * https://www.lintcode.com/problem/1254/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 左叶子的和 {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        TreeNode pre = null;
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 0));
        Stack<TreeNode> curStack = new Stack<>();
        while (!stack.isEmpty()){
            State curState = stack.pop();
            TreeNode curNode = curState.node;
            if (curNode == null){
                continue;
            }

            if (curNode.left != null){
                curStack.push(curNode);
            }
            if (curState.count == 0){
                stack.push(new State(curNode, 3));
                stack.push(new State(curNode.right, 0));
                stack.push(new State(curNode, 2));
                stack.push(new State(curNode.left, 0));
                stack.push(new State(curNode, 1));
            }
            if (curState.count == 1){
                if (curNode.left == null && curNode.right == null){

                    if (!curStack.isEmpty() && curStack.peek().left == curNode){
                        sum += curNode.val;
                    }
                }
            }
        }
        return  sum;
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
