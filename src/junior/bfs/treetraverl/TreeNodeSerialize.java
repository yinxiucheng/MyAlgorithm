package junior.bfs.treetraverl;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/7/
 *
 */
public class TreeNodeSerialize {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (null == root){
            return "{}";
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null){
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        return queueToString(queue);
    }

    private String queueToString(List<TreeNode> queue){
        while (queue.get(queue.size() - 1) == null){
            queue.remove(queue.size() - 1);
        }
        List<String> items = new ArrayList<>();
        for (TreeNode node: queue) {
            if (node == null){
                items.add("#");
            }else {
                items.add("" + node.val);
            }
        }
        return "{" + String.join("," , items) + "}";
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("{}")){
            return null;
        }
        String[] values = data.substring(1, data.length() - 1).split(",");
        List<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        boolean isLeftNode = true;
        int index = 0;

        for (int i = 1; i < values.length; i++) {
            if (!values[i].equals("#") ){
                TreeNode node = new TreeNode(Integer.parseInt(values[i]));
                if (isLeftNode){
                    queue.get(index).left = node;
                }else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftNode){
                index ++ ;
            }
            isLeftNode = !isLeftNode;

        }
        return root;

    }
}
