import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/21.
 */
public class p1089 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] dis = new int[n][n];
        for(int i = 0; i < n; i += 1){
            for(int j = 0; j < n; j += 1){
                dis[i][j] = i == j ? 0 : 10000;
                dis[j][i] = i == j ? 0 : 10000;
            }
        }
        for(int i = 0; i < m; i += 1){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            dis[a-1][b-1] = Math.min(dis[a-1][b-1], c);
            dis[b-1][a-1] = dis[a-1][b-1];
        }
        for(int i = 0; i < n; i += 1){
            for(int j = 0; j < n; j += 1){
                for(int k = 0; k < n; k += 1){
                    dis[j][k] = Math.min(dis[j][k], dis[j][i] + dis[i][k]);
                    dis[k][j] = Math.min(dis[k][j], dis[k][i] + dis[i][j]);
                }
            }
        }
        for(int i = 0; i < n; i += 1){
            System.out.print(dis[i][0]);
            for(int j = 1; j < n; j += 1){
                System.out.print(" " + dis[i][j]);
            }
            System.out.print("\n");
        }
    }
}
