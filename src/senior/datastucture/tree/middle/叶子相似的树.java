package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * https://www.lintcode.com/problem/1495/?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 叶子相似的树 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        List<Integer> list1 = minTravers(root1);
        List<Integer> list2 = minTravers(root2);
        return compareEquals(list1, list2);
    }

    private boolean compareEquals(List<Integer> list1, List<Integer> list2){
        if (list1.size() != list2.size()){
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }

    private List<Integer> minTravers(TreeNode root){
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 0));
        List<Integer> result = new ArrayList<>();
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
                if (curNode.right == null && curNode.left == null){
                    result.add(curNode.val);
                }
            }
        }
        return result;
    }


    class State {
        int count;
        TreeNode node;
        public State(TreeNode node, int count){
            this.node = node;
            this.count = count;
        }
    }
}
