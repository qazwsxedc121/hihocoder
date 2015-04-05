import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/5.
 */
public class p1051 {
    public static int find(int[] l,int m){
        int res = 0;
        int n = l.length - 2;
        if(m >= n) return 100;
        int max_p = 0;
        for(int i = 1; i < n + 2 - m; i += 1){
            int x = l[i+m] - l[i-1] - 1;
            max_p = Math.max(max_p, x);
        }
        return max_p;
    }

    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int j = 0; j < t; j += 1){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] z = new int[n+2];
            z[0] = 0;
            z[n+1] = 101;
            int last = 0;
            for(int i = 0; i < n; i += 1){
                int s = in.nextInt();
                z[i+1] = s;
            }
            System.out.println(find(z,m));
        }
    }
    public static void test(){
        m(new String[]{});
    }
}
