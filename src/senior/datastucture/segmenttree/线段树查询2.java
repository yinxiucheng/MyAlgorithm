package senior.datastucture.segmenttree;

/**
 * 247 · 线段树查询 II
 * <p>
 * https://www.lintcode.com/problem/247/?showListFe=true&page=1&problemTypeId=2&tagIds=395&pageSize=50
 */
public class 线段树查询2 {

    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end || null == root){
            return 0;
        }

        if(start <= root.start && root.end <= end) { // 相等, 陷阱，坑。
            return root.count;
        }
        // if (root.start == start && root.end == end){
        //     return root.count;
        // }
        int leftCountSum = 0;
        int rightCountSum = 0;
        int mid = root.start + (root.end - root.start) / 2;
        if (start <= mid){
            if (end > mid){
                leftCountSum = query(root.left, start, mid);
            }else {
                leftCountSum = query(root.left, start, end);
            }
        }

        if (end > mid){
            if (start <= mid){
                rightCountSum = query(root.right, mid + 1, end);
            }else {
                rightCountSum = query(root.right, start, end);
            }
        }
        return leftCountSum + rightCountSum;
    }


    public class SegmentTreeNode {
        public int start, end, count;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
}
