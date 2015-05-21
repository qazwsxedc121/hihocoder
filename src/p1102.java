import java.util.Scanner;

/**
 * User: guoxc
 * Date: 15-5-21
 * Time: 16:38
 */
public class p1102 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        double paid = in.nextDouble();
        double[] section = new double[]{0,1500,4500,9000,35000,55000,80000};
        double[] rate = new double[]{0.03,0.1,0.2,0.25,0.3,0.35,0.45};
        double[] m = new double[7];
        for(int i = 0; i < 6; i += 1){
            m[i] = (section[i+1]-section[i]) * rate[i];
        }
        double x = 0;
        double res = 3500;
        int s = 0;
        while (s < 6){
            if(paid < m[s]){
                res += paid / rate[s];
                break;
            }
            res += section[s+1] - section[s];
            paid -= m[s];
            s += 1;
        }
        if(s == 6){
            res += paid / rate[6];
        }
        System.out.println((int)Math.floor(res));

    }
}
