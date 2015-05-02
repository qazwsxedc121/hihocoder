import java.util.Scanner;

/**
 * Created by Administrator on 2015/5/2.
 */
public class p1144 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if(m - n > 1){
            System.out.println("NO");
        }else {
            System.out.println(solve(m,n));

        }
    }
    private static String solve(int m, int n){
        if(m == n){
            StringBuilder sb = new StringBuilder(m + n);
            for(int i = 0; i < m; i += 1){
                sb.append("01");
            }
            return sb.toString();
        }else if(n > m){
            String s = solve(m,m);
            StringBuilder sb = new StringBuilder(m + n);
            sb.append(s);
            for(int i = 0; i < n - m; i += 1){
                sb.append('0');
            }
            return sb.toString();
        }else if(m > n){
            StringBuilder sb = new StringBuilder(m + n);
            for(int i = 0; i < m - 1; i += 1){
                sb.append("10");
            }
            sb.append("1");
            return sb.toString();
        }else {
            return "";
        }
    }
}
