package senior.datastucture.tree.easy;


import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 0));
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

            if (state.count == 3){
                list.add(curNode.val);
            }
        }
        return list;
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
