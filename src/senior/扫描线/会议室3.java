package senior.扫描线;

import java.util.*;

/**
 * 1897 · 会议室 3
 *
 * https://www.lintcode.com/problem/1897/?showListFe=true&page=1&problemTypeId=2&tagIds=389&pageSize=50
 *
 */
public class 会议室3 {
    public static void main(String[] args) {
//        [false,true,false,true,false,true,false,false,false,true]
        int[][] intervals = {{1,3}, {4, 6}, {6, 8}, {9, 11}, {6,9}, {1, 3}, {4, 10}};
        int rooms = 3;
//        int[][] asks = {{1,9},{2,6},{7,9},{3,5},{3,9},{2,4},{7,10},{5,9},{3,10},{9,10} };
        int[][] asks = {{1,9},{2,6},{7,9}};
//        int[][] intervals = {{1,2}, {4, 5}, {8, 10}};
//        int rooms = 1;
//        int[][] asks = {{4,5},{5,6}};
        boolean[] results = meetingRoomIII(intervals, rooms, asks);
        for (int i = 0; i < results.length; i++) {
            System.out.print(" " + results[i] + ",");
        }
    }

    public static boolean[] meetingRoomIII(int[][] intervals, int rooms, int[][] asks) {
        boolean[] result = new boolean[asks.length];
        Comparator<Boundary> comparator = new Comparator<Boundary>() {
            @Override
            public int compare(Boundary o1, Boundary o2) {
                int diff = o1.num - o2.num;
                if (diff == 0){
                    diff = o1.type - o2.type;
                }
                return diff;
            }
        };
        Queue<Boundary> boundaries = new PriorityQueue<>(comparator);
        for (int[] interval: intervals) {
            Interval insertInterval = new Interval(interval[0], interval[1]);
            boundaries.offer(new Boundary(insertInterval.start, 1));
            boundaries.offer(new Boundary(insertInterval.end, -1));
        }
        int index = 0;
        for (int[] ask: asks) {
            PriorityQueue<Boundary> queue = new PriorityQueue<>(boundaries);
            result[index++] = canAdd(ask, rooms, queue);
        }
        return result;
    }

    private static boolean canAdd(int[] ask, int rooms, PriorityQueue<Boundary> boundaries){
        boundaries.offer(new Boundary(ask[0], 1));
        boundaries.offer(new Boundary(ask[1], -1));
        int meetings = 0;
        while (!boundaries.isEmpty()){
            Boundary boundary = boundaries.poll();
            if (boundary.type == 1){
                meetings ++;
            }
            if (boundary.type == -1){
                meetings --;
            }
            if (meetings > rooms){
                return  false;
            }
        }
        return true;
    }
}
