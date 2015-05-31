import java.util.*;

/**
 * Created by Administrator on 2015/5/31.
 */
public class p1174 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i += 1){
            int n = in.nextInt();
            int m = in.nextInt();
            List<List<Integer>> graph = new ArrayList<List<Integer>>();
            List<Integer> dep = new ArrayList<Integer>();
            for(int j = 0; j < n; j += 1){
                dep.add(0);
                graph.add(new ArrayList<Integer>());
            }
            for(int j = 0; j < m; j += 1){
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                dep.set(b, dep.get(b) + 1);
                graph.get(a).add(b);
            }
            if(correct(graph, dep)){
                System.out.println("Correct");
            }else {
                System.out.println("Wrong");
            }
        }
    }
    private static boolean correct(List<List<Integer>> graph, List<Integer> dep){
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        for(int i = 0; i < dep.size(); i += 1){
            if(dep.get(i) == 0){
                q.add(i);
                count += 1;
            }
        }
        while(!q.isEmpty()){
            int top = q.poll();
            for(Integer to : graph.get(top)){
                if(to == top) return false;
                dep.set(to, dep.get(to) - 1);
                if(dep.get(to) == 0){
                    q.add(to);
                    count += 1;
                }
            }
        }
        return count == dep.size();
    }
}
