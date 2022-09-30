package junior.binarytree;

import junior.datamodel.ParentTreeNode;

import java.util.HashSet;

/**
 * https://www.lintcode.com/problem/474/description?fromId=161&_from=collection
 *
 * 描述
 * 给一棵二叉树和二叉树中的两个节点，找到这两个节点的最近公共祖先LCA。
 *
 * 两个节点的最近公共祖先，是指两个节点的所有父亲节点中（包括这两个节点），离这两个节点最近的公共的节点。
 *
 * 每个节点除了左右儿子指针以外，还包含一个父亲指针parent，指向自己的父亲。
 *
 */
public class LowestCommonAncestorII {
    /**
     * @param root: root of the tree
     * @param A: the node A
     * @param B: the node B
     * @return: find the LCA of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        HashSet<ParentTreeNode> set = new HashSet<>();
        ParentTreeNode curr = A;
        while (curr != null){
            set.add(curr);
            curr = curr.parent;
        }

        curr = B;
        while (curr != null){
            if (set.contains(curr)) {
                return curr;
            }
            curr = curr.parent;
        }
       return null;
    }
}
