package junior.sumarrange;

import java.util.Arrays;

public class AddAppropriateFriends {


    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0,  right = 0, sum = 0;
        for (int age: ages) {
            if (age < 15) continue;
            while (ages[left] <= age * 0.5 - 7) left ++;

            while (right + 1 < n && ages[right + 1] < age) right ++;

            sum += right - left;
        }
        return sum;
    }


    public int numFriendRequests2(int[] ages){
        int n = ages.length;
        Arrays.sort(ages);
        int sum = 0;
        for (int i = 0, left = 0, right=0; i < n; i++) {
            while (left < i && !check(ages[left], ages[i])) left++;

            if (right < i) right = i;
            while (right< n && check(ages[right], ages[i])) right ++;
            if (right > left) sum += right - left - 1;
        }
        return sum;
    }

    private boolean check(int x, int y){
        if (y <= 0.5 * x + 7) return false;
        if(x < y) return false;
        if(y > 100 && x < 100) return false;

        return true;
    }
}
