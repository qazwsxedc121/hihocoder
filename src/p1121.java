import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/5/1.
 */
public class p1121 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i += 1){
            int n = in.nextInt();
            int m = in.nextInt();
            HashSet[] v = new HashSet[n];
            for(int j = 0; j < n; j += 1){
                v[j] = new HashSet<Integer>();
            }
            for(int j = 0; j < m; j += 1){
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                v[a].add(b);
                v[b].add(a);
            }
            if(isBi(v)){
                System.out.println("Correct");
            }else {
                System.out.println("Wrong");
            }
        }
    }
    private static boolean isBi(HashSet[] v){
        int n = v.length;
        int[] vc = new int[n];
        HashSet<Integer> vs = new HashSet<Integer>();
        for(int i = 0; i < n; i += 1){
            vs.add(i);
        }
        while(!vs.isEmpty()){
            int now = vs.iterator().next();
            vc[now] = 1;
            vs.remove(now);
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(now);
            while (!q.isEmpty()){
                int top = q.poll();
                int tc = vc[top];
                for(Object c : v[top]){
                    int ci = (Integer) c;
                    if(vc[ci] == 0){
                        vc[ci] = tc == 1 ? 2 : 1;
                        vs.remove(ci);
                        q.add(ci);
                    }else if(vc[ci] == tc){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
