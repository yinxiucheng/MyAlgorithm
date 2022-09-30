package senior.dp.博弈型;

public class 硬币排成线 {

    public boolean firstWillWin(int n) {

        boolean[] f = new boolean[n + 1];
        f[1] = true;
        f[2] = true;

        for (int i = 3; i <= n ; i++) {
            if (f[i-1] && f[i-2]){
                f[i] = false;
            }else {
                f[i] = true;
            }
        }

        return f[n];
    }
}
