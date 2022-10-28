package senior.segmenttree;

/**
 * https://www.lintcode.com/problem/207/?showListFe=true&page=1&problemTypeId=2&tagIds=395&pageSize=50
 *
 */
public class IntervalSum2 {

    SegmentTree segmentTree;

    public IntervalSum2(int[] A) {
        segmentTree = new SegmentTree(A);
    }

    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return segmentTree.query(segmentTree.root, start, end);
    }

    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        segmentTree.modify(segmentTree.root, index, value);
    }

    class SegmentTree{
        SegmentTreeNode root;

        public SegmentTree(int[] A){
            root = buildTree(A, 0, A.length - 1);
        }

        public SegmentTreeNode buildTree(int[] A, int start, int end){
            if (start > end){
                return null;
            }
            SegmentTreeNode root = new SegmentTreeNode(start, end);

            if (start != end){
                int mid = start + (end - start)/2;
                root.left = buildTree(A, start, mid);
                root.right = buildTree(A, mid + 1, end);
                root.sum = root.left.sum + root.right.sum;
            }else {
                root.sum = A[start];
            }
            return root;
        }

        public void modify(SegmentTreeNode root, int index, int value){
            if (root.start == root.end && index == root.start){
                root.sum = value;
                return;
            }
            int mid = root.start + (root.end - root.start)/2;
            if (root.start <= index && index <= mid){
                modify(root.left, index, value);
            }
            if(index <= root.end && index > mid) {
                modify(root.right, index, value);
            }
            root.sum = root.left.sum + root.right.sum;
        }

        public long query(SegmentTreeNode root, int start, int end){
            if (start == root.start && end == root.end){
                return root.sum;
            }
            long leftSum = 0;
            long rightSum = 0;
            int mid = root.start + (root.end - root.start)/2;
            if (start <= mid){
                if (end > mid){
                    leftSum = query(root.left, start, mid);
                }else {
                    leftSum = query(root.left, start, end);
                }
            }

            if (end > mid){
                if (start <= mid){
                    rightSum = query(root.right, mid+1, end);
                }else {
                    rightSum = query(root.right, start, end);
                }
            }
            return leftSum + rightSum;
        }


    }

    class SegmentTreeNode{
        public int start, end;
        public SegmentTreeNode left, right;
        public long sum;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.left = this.right = null;
            this.sum = 0;
        }
    }
}
