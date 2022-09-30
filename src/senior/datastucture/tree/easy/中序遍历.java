package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 0));
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
                list.add(curNode.val);
            }
        }
        return list;
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
