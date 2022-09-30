package junior.sumarrange;

/**
 * https://leetcode.cn/problems/corporate-flight-bookings/
 *
 * There are n flights that are labeled from 1 to n.
 *
 * You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi] represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.
 *
 * Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.
 *
 *
 */
public class CropFlightBookings {

    public int[] cropFlightBooking(int[][] bookings, int n){
        int[] c = new int[n+1];
        for (int[] book: bookings) {
            int l = book[0];
            int r = book[1];
            int v = book[2];
            c[l - 1] += v;
            c[r] -= v;
        }
        int[] ans = new int[n];
        ans[0] = c[0];
        for (int i = 1; i < n ; i++) {
            ans[i] = ans[i-1] + c[i];
        }
        return ans;
    }
}
