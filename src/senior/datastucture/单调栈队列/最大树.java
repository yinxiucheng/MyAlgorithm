package senior.datastucture.单调栈队列;

import junior.datamodel.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 126 · 最大树
 *
 * https://www.lintcode.com/problem/126/solution/18209?fromId=178&_from=collection
 *
 */
public class 最大树 {

    public TreeNode maxTree(int[] A) {

        Stack<TreeNode> stack = new Stack<>();

        for (int item: A) {
            TreeNode node = new TreeNode(item);
            TreeNode pre = null;
            while (!stack.isEmpty() && node.val > stack.peek().val){
                TreeNode curNode = stack.pop();
                //紧邻的比自己小的点为 rightChild;
                curNode.right = pre;
                pre = curNode;
            }
            //最后从Stack里弹出的，比自己小的点，为当前点的 leftChild.
            node.left = pre;
            stack.push(node);
        }

        //遍历Stack返回，Stack底部元素，为最大值点，也就是root
        TreeNode pre = null;
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            curNode.right = pre;
            pre = curNode;
        }
        return pre;
    }
}
