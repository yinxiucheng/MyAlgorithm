package junior.datamodel;

public class ParentTreeNode {
    public int val;

    public ParentTreeNode parent;
    public ParentTreeNode left;
    public ParentTreeNode right;

    ParentTreeNode(int val){
        this(val, null, null, null);
    }

    ParentTreeNode(int val, ParentTreeNode parent, ParentTreeNode left, ParentTreeNode right){
        this.val = val;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
