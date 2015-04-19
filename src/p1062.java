import java.util.*;

/**
 * Created by Administrator on 2015/4/18.
 */
public class p1062 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, String> parents = new HashMap<String, String>();
        int n = in.nextInt();
        for(int i = 0; i < n; i += 1){
            String a = in.next();
            String b = in.next();
            parents.put(b,a);
        }
        int m = in.nextInt();
        FORLOOP:for(int i = 0; i < m; i += 1) {
            String x0 = in.next();
            String x1 = in.next();
            HashSet<String> set0 = new HashSet<String>();
            if(x0.equals(x1)){
                System.out.println(x1);
                continue;
            }
            while (parents.containsKey(x0)) {
                set0.add(x0);
                x0 = parents.get(x0);
            }
            set0.add(x0);
            while (parents.containsKey(x1)) {
                if (set0.contains(x1)) {
                    System.out.println(x1);
                    continue FORLOOP;
                }
                x1 = parents.get(x1);

            }
            if (!set0.contains(x1)) {
                System.out.println(-1);
            }else {
                System.out.println(x1);
            }
        }
    }

}
