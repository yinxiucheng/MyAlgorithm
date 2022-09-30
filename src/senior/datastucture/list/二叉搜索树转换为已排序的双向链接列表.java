package senior.datastucture.list;

import junior.datamodel.TreeNode;

import java.util.Stack;

public class 二叉搜索树转换为已排序的双向链接列表 {

    public TreeNode treeToDoublyList(TreeNode root) {
        if (null == root){
            return null;
        }
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 0));
        TreeNode dummy = new TreeNode(-1);
        TreeNode preNode = dummy;
        dummy.right = root;

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
                preNode.right = curNode;
                curNode.left = preNode;
                preNode = curNode;
            }
        }
        preNode.right = dummy.right;
        dummy.right.left = preNode;
        return dummy.right;

    }

    class State{
        int count;
        TreeNode node;
        State(TreeNode node, int count){
            this.node = node;
            this.count = count;
        }
    }
}
