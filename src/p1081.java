import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/20.
 */
public class p1081 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        int[] dis = new int[n];
        for(int i = 0; i < n; i += 1){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[s-1] = 0;
        ArrayList<HashMap<Integer,Integer>> graph = new ArrayList<HashMap<Integer, Integer>>();
        for(int i = 0; i < n; i += 1){
            graph.add(new HashMap<Integer, Integer>());
        }
        for(int i = 0; i < m; i += 1){
            int a = in.nextInt();
            int b = in.nextInt();
            int l = in.nextInt();
            if(graph.get(a-1).containsKey(b-1)){
                graph.get(a-1).put(b - 1, Math.min(graph.get(a - 1).get(b - 1), l));
            }else {
                graph.get(a-1).put(b-1, l);
            }
            if(graph.get(b-1).containsKey(a-1)){
                graph.get(b-1).put(a-1, Math.min(graph.get(b-1).get(a-1), l));
            }else {
                graph.get(b-1).put(a-1, l);
            }
        }
        int p = s-1;
        HashSet<Integer> path = new HashSet<Integer>();
        path.add(s-1);
        HashSet<Integer> next = new HashSet<Integer>();
        while(p != t-1){
            int minv = -1;
            int minw = Integer.MAX_VALUE;
            for(int vp: graph.get(p).keySet()){
                if(!path.contains(vp)){
                    next.add(vp);
                    dis[vp] = Math.min(dis[vp], dis[p]+graph.get(p).get(vp));
                }
            }
            for(int vp: next){
                if(dis[vp] < minw){
                    minv = vp;
                    minw = dis[vp];
                }
            }
            next.remove(minv);
            path.add(minv);
            p = minv;
        }
        System.out.println(dis[t-1]);
    }
}
