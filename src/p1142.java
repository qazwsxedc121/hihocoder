import java.util.Scanner;

/**
 * Created by Administrator on 2015/5/3.
 */
public class p1142 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double x = in.nextDouble();
        double y = in.nextDouble();
        double left = -400;
        double right = 400;
        double res = 0;
        while (Math.abs(left - right) > 0.00001){
            double lm = left * 2.0 / 3.0 + right / 3.0;
            double rm = left / 3.0 + right * 2.0 / 3.0;
            double dlm = dis(a,b,c,x,y,lm);
            double drm = dis(a,b,c,x,y,rm);
            if(dlm < drm){
                right = rm;
            }else {
                left = lm;
            }
            res = dlm;

        }
        System.out.printf("%.3f",res);
    }
    private static double dis(double a,double b, double c, double x, double y, double X){
        return Math.sqrt((X - x) * (X - x) + Math.pow(a * X * X + b * X + c - y, 2));
    }
}
