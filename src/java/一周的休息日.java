package java;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一周的休息日
 * https://www.lintcode.com/problem/2907/description?showListFe=true&page=1&problemTypeId=6&pageSize=50
 *
 */
public class 一周的休息日 {
    static String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static Map<String, String> map = new ConcurrentHashMap<>();

    static Thread[] getWeekDay() throws Exception {
        Thread[] weekDay = new Thread[10];
        LocalDate today = LocalDate.of(2022, 11, 10);

        for (int i = 0; i < weekDay.length; i++) {
            int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    LocalDate startLocalDate = today.plusDays(finalI * 700);
                    for (int j = 0; j < 700; j++) {
                        int weekIndex = startLocalDate.getDayOfWeek().getValue() == 7 ? 0 : startLocalDate.getDayOfWeek().getValue();
                        String weekStr = day[weekIndex];
                        map.put(startLocalDate.toString(), weekStr);
                        startLocalDate = startLocalDate.plusDays(j);
                    }
                }
            });
            thread.start();
            weekDay[i] = thread;
        }
        return weekDay;
    }

}


