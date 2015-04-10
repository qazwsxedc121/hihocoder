import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/10.
 */
public class p1043 {
    public static void m() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for(int i = 0; i < n; i += 1){
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }
        int[][] dp = new int[n][m];
        for(int i = 0; i < m; i += 1){
            if(weight[0] > i){
                dp[0][i] = 0;
            }else{
                dp[0][i] = dp[0][i-weight[0]] + value[0];
            }
        }
        for(int i = 1; i < n; i += 1){
            for(int j = 0; j < m; j += 1){
                if(weight[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i][j-weight[i]] + value[i], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
