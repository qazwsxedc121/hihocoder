import java.util.*;

/**
 * Created by Administrator on 2015/6/7.
 */
public class p1175 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < k; i += 1){
            a[in.nextInt() - 1] = 1;
        }
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        int[] dep = new int[n];
        for(int i = 0; i < n; i += 1){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i += 1){
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            graph.get(from).add(to);
            dep[to] += 1;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i += 1){
            if(dep[i] == 0){
                q.add(i);
            }
        }
        int res = 0;
        while (!q.isEmpty()){
            int top = q.poll();
            int c = a[top];
            res = (res + c) % 142857;
            for(Integer i: graph.get(top)){
                a[i] = (a[i] + c) % 142857;
                dep[i] -= 1;
                if(dep[i] == 0){
                    q.add(i);
                }
            }
        }
        System.out.println(res);

    }
}
