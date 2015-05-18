import java.util.Scanner;

/**
 * User: guoxc
 * Date: 15-5-18
 * Time: 15:38
 */
public class p1164 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] xs = new double[555];
        xs[0] = 1.0;
        double sum = 1.0;
        for(int i = 1; i < (n+1); i += 1){
            xs[i] = (sum * 2) / i;
            sum += xs[i];
        }
        System.out.printf("%.6f\n", xs[n]);
    }
}
