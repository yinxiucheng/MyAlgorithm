package senior.bfs;

import junior.datamodel.Point;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 1828 · 湖面逃跑
 *
 * https://www.lintcode.com/problem/1828/description?fromId=178&_from=collection
 *
 *描述
 * Albert被困在结冰的湖面上。 他想知道他是否能回到岸上。 他目前在雪堆上，这给了他一些摩擦力。但一旦他踏进冰面，他会朝同一方向滑行，直到撞上另一个雪堆。 冰面上也有他必须避开的危险的洞。
 *
 * Albert的小狗，Kuna，也被困在一个不同的雪堆上。 Albert能找到他的小狗并把它带到岸上吗？
 *
 * Albert只能水平和垂直移动。 他最终需要来到岸边，离开湖面
 *
 * 输入包括以下参数：
 *
 * side_length: 湖面的长度（这是一个正方形）
 * lake_grid: 一个二维数组代表湖面，其中0代表冰面，1代表雪堆，-1代表洞
 * albert_row: Albert所在的雪堆的行
 * albert_column: Albert所在的雪堆的列
 * kuna_row: Kuna所在的雪堆的行
 * kuna_column: Kuna所在的雪堆的列
 */
public class 湖面逃跑 {

    public static void main(String[] args) {
        int[][] lakeGrid = {
                {1,1,1,1},
                {1,-1,-1,1},
                {-1,1,1,-1},
                {1,-1,-1,1}
        };

        boolean canScape = lakeEscape(4, lakeGrid, 2, 1, 2, 2);
        System.out.println("can Scape :" + canScape);

    }

    static class DataType{
        public static final int TYPE_ICE = 0;
        public static final int TYPE_SNOW = 1;
        public static final int TYPE_HOLE = -1;
    }

    private static final int[][] DIRECTIONS = {{1,0},{0, 1},{0, -1},{-1, 0}};

    public static boolean lakeEscape(int sideLength, int[][] lakeGrid, int albertRow, int albertColumn, int kunaRow, int kunaColumn) {

        Set<Point> visited = new HashSet<>();
        Queue<Point> queue = new ArrayDeque<>();
        Point original = new Point(albertRow, albertColumn);
        Point dogPoint = new Point(kunaRow, kunaColumn);
        queue.add(original);
        visited.add(original);

        boolean findDog = false;
        //先找狗子
        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            for (int[] direction: DIRECTIONS) {
                Point newPoint = getNextPoint(curPoint, direction, lakeGrid);
                if (newPoint.x == DataType.TYPE_HOLE || !isRange(newPoint, sideLength) || visited.contains(newPoint)){
                    continue;
                }
                if (newPoint.equals(dogPoint)) {
                   findDog = true;
                   break;
                }
                visited.add(newPoint);
                queue.add(newPoint);
            }
        }

        if (!findDog){
          return false;
        }
        visited.clear();
        queue.clear();

        queue.offer(dogPoint);
        visited.add(dogPoint);
        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            for (int[] direction: DIRECTIONS) {
                Point newPoint = getNextPoint(curPoint, direction, lakeGrid);
                if (newPoint.x == DataType.TYPE_HOLE || visited.contains(newPoint)){//换个方向走
                    continue;
                }
                if (!isRange(newPoint, sideLength)){//这里需要注意 把判断 DataType.TYPE_HOLE 放前面，因为 hole(-1, -1)掉洞里会被判为出边界了。
                    return true;
                }
                visited.add(newPoint);
                queue.offer(newPoint);
            }
        }

        return false;
    }

    private static boolean isRange(Point point, int n){
        if (point.x < 0 || point.x >= n){
            return false;
        }
        if (point.y < 0 || point.y >= n){
            return false;
        }
        return true;
    }

    private static Point getNextPoint(Point point, int[] direction, int[][] lakeGrid){
        Point curPoint = new Point(point.x + direction[0], point.y + direction[1]);
        int n = lakeGrid.length;
        while (isRange(curPoint, n)){
            if (lakeGrid[curPoint.x][curPoint.y] == DataType.TYPE_HOLE){
                return new Point(-1, -1);
            }
            if (lakeGrid[curPoint.x][curPoint.y] == DataType.TYPE_SNOW){
                return curPoint;
            }
            curPoint.x += direction[0];
            curPoint.y += direction[1];
        }
        return curPoint;
    }
}
