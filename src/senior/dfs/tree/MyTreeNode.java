package senior.dfs.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 262 · 继承人树
 *
 * https://www.lintcode.com/problem/262/description?fromId=178&_from=collection
 *
 */
public class MyTreeNode {

    int val;
    List<MyTreeNode> children;
    MyTreeNode parent;
    boolean isDelete;

    /**
     * @param val: the val of the node
     * @return: a MyTreeNode Object
     */
    MyTreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
        this.parent = null;
        this.isDelete = false;
    }

    /**
     * @param root: the root treenode
     * @return: get the traverse of the treenode
     */
    public ArrayList<Integer> traverse(MyTreeNode root) {
        ArrayList<Integer> path = new ArrayList<>();
        traverseHelper(root, path);
        return path;
    }

    private void traverseHelper(MyTreeNode root, ArrayList<Integer> path){
        if (!root.isDelete){
            path.add(root.val);
        }
        for (MyTreeNode child : root.children) {
            traverseHelper(child, path);
        }
    }

    /**
     * @param root: the node where added
     * @param value: the added node's value
     * @return: add a node, return the node
     */
    public MyTreeNode addNode(MyTreeNode root, int value) {
        MyTreeNode newNode = new MyTreeNode(value);
        root.children.add(newNode);
        newNode.parent = root;
        return newNode;
    }

    /**
     * @param root: the deleted node
     * @return: nothing
     */
    public void deleteNode(MyTreeNode root) {
        root.isDelete = true;
    }
}
