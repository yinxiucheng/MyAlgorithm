package senior.datastucture.segmenttree;

/**
 *
 */
public class 我的日历3 {

    class SegmentTreeNode{
        int start, end;
        SegmentTreeNode left, right;
        int max;

        public SegmentTreeNode(int start, int end, int max){
            this.start = start;
            this.end = end;
            this.max = max;
        }
    }

    class MyCalendarThree{
        SegmentTreeNode root;

        public MyCalendarThree(){
            root = buildTree(0, 1000000000);
        }

        public SegmentTreeNode buildTree(int start, int end){
            if (start > end){
                return null;
            }
            SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
            if (start != end){
                int mid = start + (end - start)/2;
                root.left = buildTree(start, mid);
                root.right = buildTree(mid+1, end);
                root.max = Math.max(root.left.max,  root.right.max);
            }else {
                root.max = 0;
            }
            return root;
        }

        int book(int start, int end) {
            for (int i = start; i < end; i++) {
                modify(root, i, 1);
            }
            return root.max;
        }

        public void modify(SegmentTreeNode root, int index, int value) {
            if (root.start == root.end && index == root.start){
                root.max += value;
                return;
            }
            int mid = (root.start + root.end)/2;
            if (root.start <= index && index <= mid){
                modify(root.left, index, value);
            }

            if (mid < index && index <= root.end){
                modify(root.right, index, value);
            }
            root.max = Math.max(root.left.max, root.right.max);
        }
    }
}
