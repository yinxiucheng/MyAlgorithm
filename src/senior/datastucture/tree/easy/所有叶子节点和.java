package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.Stack;

public class 所有叶子节点和 {

    public int sumLeafNode(TreeNode root) {
        int sum = 0;
        Stack<State> stack = new Stack<>();
        stack.push(new State(0, root));

        while (!stack.isEmpty()){
            State curState = stack.pop();
            TreeNode curNode = curState.node;

            if (curState.count == 0){
                stack.push(new State(3, curNode));
                stack.push(new State(0, curNode.right));
                stack.push(new State(2, curNode));
                stack.push(new State(0, curNode.left));
                stack.push(new State(1, curNode));
            }

            if (curState.count == 1){
                if (curNode.left == null && curNode.right == null){
                    sum += curNode.val;
                }
            }
        }

        return sum;
    }

    class State{
        int count;
        TreeNode node;

        public State(int count, TreeNode node){
            this.count = count;
            this.node = node;
        }
    }
}
