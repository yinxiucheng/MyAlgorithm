package junior.datastructure.heap;

import junior.datamodel.Point;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/612/description?fromId=161&_from=collection
 * 描述
 * 在二维空间里给定一些 points 和一个 origin，从 points 中找到 k 个离 origin 欧几里得距离最近的点。
 * 按照欧几里得距离由小到大返回。如果两个点有相同欧几里得距离，则按照x值来排序；若x值也相同，就再按照y值排序。
 */
public class KClosest {

    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        Queue<Point> heap = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                int diff = getDistance(origin, b) - getDistance(origin, a);
                if (diff == 0){
                    diff = b.x - a.x;
                }
                if (diff == 0){
                    diff = b.y - b.y;
                }
                return diff;
            }
        });

        for (int i = 0; i < points.length ; i++) {
            heap.offer(points[i]);
            if (heap.size() > k){
                heap.poll();
            }
        }
        Point[] result = new Point[k];
        int i = k;
        while (!heap.isEmpty()){
            result[--i] = heap.poll();
        }
        return result;
    }

    public int getDistance(Point a, Point b){
        return (a.x - b.x)^2 + (a.y - b.y)^2;
    }
}
