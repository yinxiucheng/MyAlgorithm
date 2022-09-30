package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.Stack;

/**
 * https://www.lintcode.com/problem/1033/?fromId=295&_from=collection
 *
 */
public class BST中的最小差值 {

    public int minDiffInBST(TreeNode root) {
        if (null == root){
            return 0;
        }

        Stack<State> stack = new Stack<>();
        stack.push(new State(0, root));
        TreeNode preNode = null;
        int ans = Integer.MAX_VALUE;
        while (!stack.isEmpty()){
            State curState = stack.pop();
            TreeNode curNode = curState.node;
            if (curNode == null){
                continue;
            }
            if (curState.count == 0){
                stack.push(new State(3, curNode));
                stack.push(new State(0, curNode.right));
                stack.push(new State(2, curNode));
                stack.push(new State(0, curNode.left));
                stack.push(new State(1, curNode));
            }
            if (curState.count == 2){
                if (preNode != null){
                  ans = Math.min(ans, Math.abs(preNode.val - curNode.val));
                }
                preNode = curNode;
            }
        }
        return ans;
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
