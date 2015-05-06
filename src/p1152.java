import java.util.*;

/**
 * User: guoxc
 * Date: 15-5-6
 * Time: 22:36
 */
public class p1152 {
    public static void m(String[] args) {
        fibs = new HashSet<Integer>();
        int a = 1;
        int b = 1;
        while (b < 100){
            fibs.add(b);
            int t = a + b;
            a = b;
            b = t;
        }
        Scanner in = new Scanner(System.in);
        String s = in.next();
        Set<String> subs = new HashSet<String>();
        for(int i = 0; i < s.length(); i += 1){
            for(int j = i + 1; j < s.length() + 1; j += 1){
                subs.add(s.substring(i,j));
            }
        }
        List<String> l = new ArrayList<String>();
        l.addAll(subs);
        Collections.sort(l);
        for(int i = 0; i < l.size(); i += 1){
            String rs = l.get(i);
            if(isLucky(rs)){
                System.out.println(rs);
            }
        }
    }
    private static boolean isLucky(String s){
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i += 1){
            set.add(s.charAt(i));
        }
        return fibs.contains(set.size());
    }
    private static Set<Integer> fibs;
}
