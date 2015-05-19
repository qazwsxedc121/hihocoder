import java.util.Scanner;

/**
 * User: guoxc
 * Date: 15-5-19
 * Time: 19:34
 */
public class p1095 {
    public static int n;
    public static int k;
    public static int[] seq;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        seq = new int[n];
        for(int i = 0; i < n; i += 1){
            seq[i] = in.nextInt();
        }
        int l = 0;
        int r = k;
        if(pass(seq,0)){
            System.out.println(0);
            return;
        }else if(!pass(seq, k)){
            System.out.println(k+1);
            return;
        }
        int mid = 0;
        while (r - l > 1){
            mid = (l + r) / 2;
            if(pass(seq, mid)){
                r = mid;
            }else{
                l = mid;
            }
        }
        System.out.println(r);
    }
    public static boolean pass(int[] seq, int t){
        int ho = 0;
        int c = 0;
        for(int i = 0; i < n; i += 1){
            c += t;
            if(c > seq[i]){
                ho += 1;
                c -= seq[i];
            }else{
                c = 0;
            }
        }
        return ho > (n / 2);
    }
}
