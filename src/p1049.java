import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/14.
 */
public class p1049 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(solve(a,b));
    }
    public static String solve(String a, String b){
        if(a.length() == 0) return a;
        else if(a.length() == 1) return a;
        char root = a.charAt(0);
        int ri = 0;
        int n = b.length();
        for(int i = 0; i < n; i += 1){
            if(b.charAt(i) == root){
                ri = i;
                break;
            }
        }
        return solve(a.substring(1,ri+1), b.substring(0,ri)) + solve(a.substring(ri+1),b.substring(ri+1)) + root;
    }
}
