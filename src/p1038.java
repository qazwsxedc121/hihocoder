import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/4.
 */
public class p1038 {
    public static int pack(int n,int[] w,int[] v, int limit){
        int[][] dp = new int[n][limit];
        for(int i = 0; i < limit; i += 1){
            if(i > w[0]){
                dp[0][i] = v[0];
            }
        }
        for(int i = 1; i < n; i += 1){
            for(int j = 0; j < limit; j += 1){
                if(j < w[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        return dp[n-1][limit-1];
    }

    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int limit = in.nextInt() + 1;
        int[] v = new int[n];
        int[] w = new int[n];
        for(int i = 0; i < n; i += 1){
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }
        System.out.println(pack(n,w,v,limit));
    }
    public static void test(){
        int n = 5;
        int limit = 1001;
        int[] v = new int[]{990,436,673,58,897};
        int[] w = new int[]{144,487,210,567,1056};
        System.out.println(pack(n,w,v,limit));
    }
}
