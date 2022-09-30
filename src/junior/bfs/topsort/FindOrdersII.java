package junior.bfs.topsort;

import java.util.*;

/**
 * 616 · 课程表 II
 *
 * https://www.lintcode.com/problem/616/
 *
 * 描述
 * 你需要去上n门九章的课才能获得offer，这些课被标号为 0 到 n-1 。
 * 有一些课程需要“前置课程”，比如如果你要上课程0，你需要先学课程1，我们用一个匹配来表示他们： [0,1]
 *
 * 给你课程的总数量和一些前置课程的需求，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 例1:
 *
 * 输入: n = 2, prerequisites = [[1,0]]
 * 输出: [0,1]
 *
 * 例2:
 *
 * 输入: n = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 */
public class FindOrdersII {

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}};
        int[] result = findOrder(2, prerequisites);
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //构图
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] coursePre = prerequisites[i];
            int curCourse = coursePre[0];
            int preCourse = coursePre[1];
            //preCourse, curCourse必须在 numCourse的范围内。
            graph.get(preCourse).add(curCourse);
        }

        Map<Integer, Integer> indegree = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
            List<Integer> succeedCourse = entry.getValue();
            for (Integer neighbor: succeedCourse) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int[] order = new int[numCourses];
        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
            int course = entry.getKey();
            if (!indegree.containsKey(course)){
                queue.offer(course);
                order[count++] = course;
            }
        }

        while (!queue.isEmpty()){
            Integer course = queue.poll();
            List<Integer> succeedCourseList = graph.get(course);
            if (null != succeedCourseList){
                for (Integer succeedCourse: succeedCourseList) {
                    indegree.put(succeedCourse, indegree.get(succeedCourse) - 1);
                    if (indegree.get(succeedCourse) == 0){
                        queue.offer(succeedCourse);
                        order[count++] = succeedCourse;
                    }
                }
            }
        }

        if (count == numCourses){
            return order;
        }
        return new int[0];
    }
}
