import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2015/6/5.
 */
public class p1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());
        int[] weight = new int[n];
        for(int i = 0; i < n; i += 1){
            weight[i] = Integer.parseInt(bfr.readLine());
        }
        int bmax = 1;
        while((1 << bmax) < n){
            bmax += 1;
        }
        int[][] dp = new int[bmax][n];
        for(int i = 0; i < n; i += 1){
            dp[0][i] = weight[i];
        }
        for(int j = 1; j < bmax; j += 1){
            for(int i = 0; i < n; i += 1){
                if(i + (1<< (j - 1)) < n) {
                    dp[j][i] = Math.min(dp[j - 1][i], dp[j - 1][i + (1 << (j - 1))]);
                }else{
                    dp[j][i] = dp[j-1][i];
                }
            }
        }
        int q = Integer.parseInt(bfr.readLine());
        for(int i = 0; i < q; i += 1){
            String[] z = bfr.readLine().split(" ");
            int l = Integer.parseInt(z[0])-1;
            int r = Integer.parseInt(z[1])-1;
            int k = 0;
            while((1 << k) <= (r - l + 1)){
                k += 1;
            }
            k -= 1;
            System.out.println(Math.min(dp[k][l],dp[k][r - (1 << k) + 1]));
        }
    }
}
