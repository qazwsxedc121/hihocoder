import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/18.
 */
public class p1044 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[] w = new int[n];
        for(int i = 0; i < n; i += 1){
            w[i] = in.nextInt();
        }
        int[][] best = new int[n][1<<m];
        int[][] choose = new int[n][1<<(m+1)];
        for(int i = 0; i < n; i += 1) {
            for (int j = 0; j < 1 << m; j += 1) {
                best[i][j] = -1;
            }
        }
        best[0][0] = 0;
        best[0][1 << (m-1)] = w[0];
        for(int i = 0; i < n - 1; i += 1){
            for(int j = 0; j < 1 << m; j += 1){
                if(best[i][j] == -1) continue;
                if(calcOne(j>>1) < q){
                    best[i+1][(j >> 1) + (1 << (m-1))] = Math.max(best[i+1][(j >> 1) + (1 << (m-1))],
                            best[i][j] + w[i+1]);

                }
                best[i+1][j >> 1] = Math.max(best[i+1][j >> 1], best[i][j]);

            }
        }
        int max = 0;
        for(int i = 0; i < 1 << m; i += 1){
            max = Math.max(max, best[n-1][i]);
        }
        System.out.println(max);
    }
    private static int calcOne(int bits){
        int res = 0;
        while(bits > 0){
            if((bits & 1) == 1){
                res += 1;
            }
            bits = bits >> 1;
        }
        return res;
    }
}
