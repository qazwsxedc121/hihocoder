import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/19.
 */
public class p1066 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String,String> rep = new HashMap<String, String>();
        for(int i = 0; i < n; i += 1){
            int op = in.nextInt();
            String a = in.next();
            String b = in.next();
            if(!rep.containsKey(a)){
                rep.put(a,a);
            }
            if(!rep.containsKey(b)){
                rep.put(b,b);
            }
            if(op == 0){
                String ao = findRep(rep,a);
                String bo = findRep(rep,b);
                rep.put(ao,bo);

            }else {
                String ao = findRep(rep,a);
                if(!a.equals(ao)) {
                    rep.put(a, ao);
                }
                String bo = findRep(rep,b);
                if(!b.equals(bo)) {
                    rep.put(b,bo);
                }
                if(ao.equals(bo)){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }

            }
        }
    }
    private static String findRep(HashMap<String,String> map, String key){
        if(map.get(key).equals(key)){
            return key;
        }else {
            return findRep(map,map.get(key));
        }
    }
}
