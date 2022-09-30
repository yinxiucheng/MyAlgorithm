package junior.bfs.topsort;

import java.util.*;

/**
 * 615 · 课程表
 * https://www.lintcode.com/problem/615/
 *
 * 描述
 * 现在你总共有 n 门课需要选，记为 0 到 n - 1.
 * 一些课程在修之前需要先修另外的一些课程，比如要学习课程 0 你需要先学习课程 1 ，表示为[0,1]
 * 给定n门课以及他们的先决条件，判断是否可能完成所有课程？
 */
public class CanFinish {

    /**
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
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
            List<Integer> neighbors = entry.getValue();
            for (Integer neighbor: neighbors) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int[] order = new int[numCourses];
        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
            Integer course = entry.getKey();
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
        return count == numCourses;
    }
}
