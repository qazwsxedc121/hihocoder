import java.util.Scanner;

/**
 * User: guoxc
 * Date: 15-4-3
 * Time: 15:28
 */
public class p1037 {
    public static int solve(int[][] triangle, int n){
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < n; i += 1){
            for(int j = 0; j <= i; j += 1){
                if(j == 0){
                    dp[i][j] = dp[i-1][j];
                }else if(j == i){
                    dp[i][j] = dp[i-1][i-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
                dp[i][j] += triangle[i][j];
            }
        }
        int res = dp[n-1][0];
        for(int i = 1; i < n; i += 1){
            res = Math.max(res, dp[n-1][i]);
        }
        return res;
    }
    public static void test(){
        int[][] data = new int[][]{
                {2,0,0,0,0},
                {6,4,0,0,0},
                {1,2,8,0,0},
                {4,0,9,6,0},
                {6,5,5,3,6}
        };
        System.out.println(solve(data, 5));
    }

    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] data = new int[n][n];
        for(int i = 0; i < n; i += 1){
            for(int j = 0; j <= i; j += 1){
                data[i][j] = in.nextInt();
            }
        }
        System.out.println(solve(data,n));
    }
}
