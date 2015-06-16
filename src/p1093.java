import java.util.*;

/**
 * Created by Administrator on 2015/6/16.
 */
public class p1093 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt() - 1;
        int t = in.nextInt() - 1;
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<Integer, HashMap<Integer, Integer>>();
        for(int i = 0; i < n; i += 1){
            graph.put(i, new HashMap<Integer, Integer>());
        }
        for(int i = 0; i < m; i += 1){
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int l = in.nextInt();

            if(graph.get(a).containsKey(b)){
                int c = graph.get(a).get(b);
                if(l < c){
                    graph.get(a).put(b, l);
                }
            }else{
                graph.get(a).put(b, l);
            }

            if(graph.get(b).containsKey(a)){
                int c = graph.get(b).get(a);
                if(l < c){
                    graph.get(b).put(a, l);
                }
            }else{
                graph.get(b).put(a, l);
            }
        }

        int[] dist = new int[n];
        for(int i = 0; i < n; i += 1){
            dist[i] = -1;
        }
        dist[s] = 0;

        HashSet<Integer> qset = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        qset.add(s);

        while (!q.isEmpty()) {
            int top = q.poll();
            qset.remove(top);
            for(Integer next: graph.get(top).keySet()){
                if(dist[next] == -1){
                    q.add(next);
                    qset.add(next);
                    dist[next] = dist[top] + graph.get(top).get(next);
                }else if(dist[top] + graph.get(top).get(next) <  dist[next]){
                    dist[next] = dist[top] + graph.get(top).get(next);
                    if(!qset.contains(next)){
                        q.add(next);
                        qset.add(next);
                    }
                }
            }
        }

        System.out.println(dist[t]);
    }
}
