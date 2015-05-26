import java.util.Scanner;

/**
 * Created by Administrator on 2015/5/26.
 */
public class p1151 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] m = new int[][]{
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,1,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0,1},
                {0,0,0,1,0,0,0,0},
                {0,0,1,0,0,0,0,0},
                {0,1,0,0,0,0,0,1},
                {1,0,0,1,0,0,1,0},
        };
        if(n % 2 == 1){
            System.out.println("0");
            return;
        }
        int[] dp = new int[]{0,0,0,0,0,0,0,1};
        int[] dp2 = new int[]{0,0,0,0,0,0,0,0};
        for(int i = 0; i < n; i += 2){
            for(int j = 0; j < 8; j += 3) {
                dp2[j] = 0;
                for (int k = 1; k < 8; k += 3) {
                    if (m[j][k] == 1) {
                        dp2[j] += dp[k];
                    }
                }
                dp2[j] = dp2[j] % 12357;
            }
            for(int j = 1; j < 8; j += 3){
                dp[j] = 0;
                for(int k = 0; k < 8; k += 3){
                    if(m[j][k] == 1){
                        dp[j] += dp2[k];
                    }
                }
                dp[j] = dp[j] % 12357;
            }
        }
        System.out.println(dp[7]);
    }
}
