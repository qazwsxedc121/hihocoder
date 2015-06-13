import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/6/13.
 */
public class p1176 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] vn = new int[n];
        for(int i = 0; i < n; i += 1){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i += 1){
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
            vn[a] += 1;
            vn[b] += 1;
        }
        int zc = 0;
        int oc = 0;
        for(int i = 0; i < n; i += 1){
            if(vn[i] == 0){
                zc += 1;
            }else if(vn[i] % 2 == 1){
                oc += 1;
            }
        }
        if(isConnected(graph) && zc == 0 && (oc == 2 || oc == 0)){
            System.out.println("Full");
        }else {
            System.out.println("Part");
        }
    }
    private static boolean isConnected(ArrayList<ArrayList<Integer>> graph){
        int n = graph.size();
        boolean[] visited = new boolean[n];
        int p = 0;
        int c = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(p);
        visited[0] = true;
        c += 1;
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(Integer next : graph.get(top)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    c += 1;
                }
            }
        }
        return c == n;
    }
}
