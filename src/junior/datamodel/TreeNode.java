package junior.datamodel;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(){}
    public TreeNode(int val){
        this(val, null, null);

    }

    TreeNode(int val, TreeNode leftChild, TreeNode rightChild){
        this.val = val;
        this.left = leftChild;
        this.right = rightChild;
    }
}
