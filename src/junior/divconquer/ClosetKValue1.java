package junior.divconquer;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosetKValue1 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        node.left = node1;
        node.right = node3;
        node1.left = node2;
        node3.left = node4;
        node3.right = node6;
        node4.left = node5;

        List<Integer> results = closestKValues(node, 6.5, 4);
    }

    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();

        if (k == 0 || root == null) {
            return values;
        }

        Stack<TreeNode> lowerStack = getStack(root, target);
        Stack<TreeNode> upperStack = new Stack<>();
        upperStack.addAll(lowerStack);
        if (target < lowerStack.peek().val) {
            moveLower(lowerStack);
        } else {
            moveUpper(upperStack);
        }

        for (int i = 0; i < k; i++) {
            if (lowerStack.isEmpty() ||
                    !upperStack.isEmpty() && target - lowerStack.peek().val > upperStack.peek().val - target) {
                values.add(upperStack.peek().val);
                moveUpper(upperStack);
            } else {
                values.add(lowerStack.peek().val);
                moveLower(lowerStack);
            }
        }

        return values;
    }

    private static Stack<TreeNode> getStack(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);

            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return stack;
    }

    public static void moveUpper(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();
        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
            return;
        }

        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void moveLower(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();
        if (node.left == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().left == node) {
                node = stack.pop();
            }
            return;
        }

        node = node.left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }
}
