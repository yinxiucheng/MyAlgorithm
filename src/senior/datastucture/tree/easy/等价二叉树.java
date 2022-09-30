package senior.datastucture.tree.easy;

import junior.datamodel.TreeNode;

import java.util.Stack;

/**
 * 469 · 等价二叉树
 *
 */
public class 等价二叉树 {

    // 前序、中序遍历一样。
    public boolean isIdentical(TreeNode A, TreeNode B) {
        String preAStr = getTraverStr(A, 1);
        String preBStr = getTraverStr(B, 1);
        String midAStr = getTraverStr(A, 2);
        String midBStr = getTraverStr(B, 2);
        return preAStr.equals(preBStr) && midAStr.equals(midBStr);
    }

    public String getTraverStr(TreeNode root, int type){
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 0));
        StringBuilder builderPre = new StringBuilder();
        StringBuilder builderMid = new StringBuilder();
        StringBuilder builderEnd = new StringBuilder();

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

            if (curState.count == 1){
                builderPre.append(curNode.val).append(",");
            }

            if (curState.count == 2){
                builderMid.append(curNode.val).append(",");
            }

            if (curState.count == 3){
                builderEnd.append(curNode.val).append(",");
            }
        }

        if (type == 1){
            String str = builderPre.toString();
            if (str.isEmpty()) return "";
            return str.substring(0, str.length() - 1);
        }

        if (type == 2){
            String str = builderMid.toString();
            if (str.isEmpty()) return "";
            return str.substring(0, str.length() - 1);
        }

        if (type == 3){
            String str = builderEnd.toString();
            if (str.isEmpty()) return "";
            return str.substring(0, str.length() - 1);
        }

        return "";
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
