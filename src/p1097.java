import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/30.
 */
public class p1097 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] dis = new int[n][n];
        for(int i = 0; i < n; i += 1){
            for(int j = 0; j < n; j += 1){
                dis[i][j] = in.nextInt();
            }
        }
        int[] z = new int[n];
        for(int i = 0; i < n; i += 1){
            z[i] = dis[0][i];
        }
        int k = 1;
        int res = 0;
        while (k < n){
            int m = 10000;
            int mi = -1;
            for(int i = 0; i < n; i += 1){
                if(z[i] != 0){
                    if(z[i] < m){
                        mi = i;
                        m = z[i];
                    }
                }
            }
            z[mi] = 0;
            res += m;
            for(int i = 0; i < n; i += 1){
                if(z[i] != 0){
                    z[i] = Math.min(z[i], dis[mi][i]);
                }
            }
            k += 1;
        }
        System.out.println(res);
    }
}
