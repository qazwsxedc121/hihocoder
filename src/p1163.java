import java.util.Scanner;

/**
 * Created by Administrator on 2015/5/16.
 */
public class p1163 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i += 1){
            a[i] = in.nextInt();
        }
        int res = 0;
        for(int i = 0; i < n; i += 1){
            res ^= a[i];
        }
        if(res == 0){
            System.out.println("Bob");
        }else {
            System.out.println("Alice");
        }
    }
}
