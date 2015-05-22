import java.util.*;

/**
 * User: guoxc
 * Date: 15-5-22
 * Time: 17:56
 */
public class p1139 {
    private static int n,m,k,t;
    private static HashMap<Integer, HashMap<Integer, Integer>> map;
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        t = in.nextInt() - 1;
        map = new HashMap<Integer, HashMap<Integer,Integer>>();
        for(int i = 0; i < n; i += 1){
            map.put(i, new HashMap<Integer,Integer>());
        }
        for(int i = 0; i < m; i += 1){
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            int w = in.nextInt();
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, w);
            }else{
                map.get(x).put(y, Math.min(map.get(x).get(y), w));
            }
            if(!map.get(y).containsKey(x)){
                map.get(y).put(x, w);
            }else{
                map.get(y).put(x, Math.min(map.get(y).get(x), w));
            }
        }
        int l = 0;
        int r = 2000000;
        if(f(l)){
            System.out.println("0");
            return;
        }
        while (r - l > 1){
            int mid = (l + r) / 2;
            if(f(mid)){
                r = mid;
            }else{
                l = mid;
            }
        }
        System.out.println(r);

    }

    private static boolean f(int s){
        boolean[] visited = new boolean[n];
        visited[0] = true;
        ArrayList<Integer> al0 = new ArrayList<Integer>();
        al0.add(0);
        int x = 0;
        while (x < k){
            ArrayList<Integer> al1 = new ArrayList<Integer>();
            for(Integer node : al0){
                for(Integer i : map.get(node).keySet()){
                    if(map.get(node).get(i) <= s && !visited[i]){
                        if(i == t)
                            return true;
                        al1.add(i);
                        visited[i] = true;
                    }
                }
            }
            x += 1;
            al0 = al1;
        }
        return false;

    }
}

