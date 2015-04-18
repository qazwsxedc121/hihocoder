import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/18.
 */
public class p1062 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, String> parents = new HashMap<String, String>();
        int n = in.nextInt();
        for(int i = 0; i < n; i += 1){
            String a = in.next();
            String b = in.next();
            parents.put(b,a);
        }
        int m = in.nextInt();
        for(int i = 0; i < m; i += 1) {
            String x0 = in.next();
            String x1 = in.next();
            ArrayList<String> list0 = new ArrayList<String>();
            ArrayList<String> list1 = new ArrayList<String>();
            while(parents.containsKey(x0)){
                list0.add(x0);
                x0 = parents.get(x0);
            };
            while(parents.containsKey(x1)){
                list1.add(x1);
                x1 = parents.get(x1);
            };
            String res = findParents(list0, list1);
            if(res != null ){
                System.out.println(res);
            }else {
                System.out.println(-1);
            }
        }


    }
    private static String findParents(List<String> l0, List<String> l1){
        for(int i = 0; i < l0.size(); i += 1){
            String a = l0.get(i);
            for(int j = 0; j < l1.size(); j += 1){
                String b = l1.get(j);
                if(a.equals(b)){
                    return a;
                }
            }
        }
        return null;
    }
}
