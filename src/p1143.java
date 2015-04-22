
import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/22.
 */
public class p1143 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(fib(n));
    }
    private static long fib(long n){
        boolean[] bits = new boolean[32];
        for(int i = 0; i < 32; i += 1){
            bits[i] = (n & (1 << i)) > 0;
        }
        long[][] a = new long[32][4];
        a[0] = new long[]{0,1,1,1};
        for(int i = 1; i < 32; i += 1){
            a[i] = matrixMult(a[i-1], a[i-1]);
        }
        long[] res = new long[]{1,0,0,1};
        for(int i = 0; i < 32; i += 1){
            if(bits[i]){
                res = matrixMult(res, a[i]);
            }
        }
        return res[3];
    }
    private static long[] matrixMult(long[] a, long[] b){
        return new long[]{
                (a[0]*b[0] + a[1]*b[2]) % 19999997,
                (a[0]*b[1] + a[1]*b[3]) % 19999997,
                (a[2]*b[0] + a[3]*b[2]) % 19999997,
                (a[2]*b[1] + a[3]*b[3]) % 19999997
        };
    }
}
