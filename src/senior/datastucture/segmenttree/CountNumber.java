package senior.datastucture.segmenttree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.lintcode.com/problem/249/?showListFe=true&page=1&problemTypeId=2&tagIds=395&pageSize=50
 *
 */
public class CountNumber {

    public List<Integer> countOfSmallerNumberII(int[] a) {
        SegmentTree segmentTree = new SegmentTree(0, 10000);
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int index = a[i];
            segmentTree.add(index, 1);
            if (index == 0) {
                results.add(0);
            } else {
                int num = segmentTree.query(0, index - 1);
                results.add(num);
            }
        }
        return results;
    }

    class SegmentTree{
        SegmentTreeNode root;

        SegmentTree(int start, int end){
            root = buildTree(start, end);
        }

        SegmentTreeNode buildTree(int start, int end) {
            if (start > end) {
                return null;
            }
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start != end) {
                int mid = start + (end - start) / 2;
                root.left = buildTree(start, mid);
                root.right = buildTree(mid + 1, end);
                root.value = root.left.value + root.right.value;
            } else {
                root.value = 0;
            }
            return root;
        }

        int query(int start, int end){
            return query(root, start, end);
        }

        int query(SegmentTreeNode root, int start, int end){
            if (root.start == start && root.end == end){
                return root.value;
            }
            int mid = (root.start + root.end)/2;
            int leftSum = 0; int rightSum = 0;
            if (start <= mid) {
                leftSum = query(root.left, start, Math.min(mid, end));
            }
            if (mid < end){
                rightSum = query(root.right, Math.max(mid + 1, start), end);
            }
            return leftSum + rightSum;
        }

        void modify(int index, int value){
            modify(root, index, value);
        }

        void modify(SegmentTreeNode root, int index, int value) {
            if (root.start == root.end && root.start == index) {
                root.value = value;
                return;
            }
            int mid = (root.start + root.end) / 2;
            if (index <= mid) {
                modify(root.left, index, value);
            } else {
                modify(root.right, index, value);
            }
            root.value = root.left.value + root.right.value;//todo 一定记住要更新。
        }

        void add(int index, int value){
            add(root, index, value);
        }

        void add(SegmentTreeNode root, int index, int value){
            if (root.start == root.end && root.start == index) {
                root.value += value;
                return;
            }
            int mid = (root.start + root.end) / 2;
            if (index <= mid) {
                add(root.left, index, value);
            } else {
                add(root.right, index, value);
            }
            root.value = root.left.value + root.right.value;
        }
    }

    class SegmentTreeNode{
        int start, end;
        SegmentTreeNode left, right;
        int value;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.left = this.right = null;
            int value = 0;
        }
    }
}
