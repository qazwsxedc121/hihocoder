
import java.util.*;

public class p1181{
    public static int n;
    public static int m;
    public static HashMap<Integer, ArrayList<Integer>> graph;
    public static HashMap<Integer, ArrayList<Boolean>> graph_v;
    public static ArrayList<Integer> res;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new HashMap<Integer, ArrayList<Integer>>();
        graph_v = new HashMap<Integer, ArrayList<Boolean>>();
        for(int i = 0; i < n; i += 1){
            graph.put(i + 1, new ArrayList<Integer>());
            graph_v.put(i + 1, new ArrayList<Boolean>());
        }
        for(int i = 0; i < m; i += 1){
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
            graph_v.get(a).add(false);
            graph_v.get(b).add(false);
        }
        int start = 1;
        for(int i = 0; i < n; i += 1){
            if((graph.get(i+1).size() % 2) == 1){
                start = i + 1;
                break;
            }
        }
        res = new ArrayList<Integer>();
        DFS(start);
        String resS = "" + res.get(0);
        for(int i = 1; i < res.size(); i += 1){
            resS += " " + res.get(i);
        }
        System.out.println(resS);
    }
    private static void DFS(int start){
        int v_len = graph.get(start).size();
        for(int i = 0; i < v_len; i += 1){
            if(!graph_v.get(start).get(i)){
                int next = graph.get(start).get(i);
                int n_len = graph.get(next).size();
                for(int j = 0; j < n_len; j += 1){
                    if(!graph_v.get(next).get(j) && graph.get(next).get(j) == start){
                        graph_v.get(next).set(j, true);
                        break;
                    }
                }
                graph_v.get(start).set(i, true);
                DFS(next);
            }
        }
        res.add(start);
    }
}