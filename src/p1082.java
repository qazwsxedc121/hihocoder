import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2015/4/17.
 */
public class p1082 {
    public static void m(String[] args) {
        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            String s = b.readLine();
            while (s != null) {
                System.out.println(swap(s));
                s = b.readLine();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private static String swap(String o){
        int n = o.length();
        StringBuilder sb = new StringBuilder(n);
        for(int i = 0; i < n; i += 1){
            if((o.charAt(i) == 'M' || o.charAt(i) == 'm')
                    && i < n - 8
                    && o.substring(i,i+9).toLowerCase().equals("marshtomp")){
                i += 8;
                sb.append("fjxmlhx");
            }else{
                sb.append(o.charAt(i));
            }
        }
        return sb.toString();
    }
}
