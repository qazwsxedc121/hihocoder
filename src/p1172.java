import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/6/14.
 */
public class p1172 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < n; i += 1){
            if(s.charAt(i) == 'H'){
                l.add(i+1);
            }
        }
        int res = 0;
        for(Integer i: l){
            res = res ^ i;
        }
        if(res == 0){
            System.out.println("Bob");
        }else {
            System.out.println("Alice");
        }
    }
}
