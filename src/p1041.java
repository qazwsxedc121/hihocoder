
import java.util.HashSet;
import java.util.Scanner;

public class p1041 {
    private static class TreeNode{
        public int city;
        public TreeNode parent;
        public HashSet<TreeNode> sub;
        public HashSet<Integer> subcitys;
        public TreeNode(int c, boolean[][] map, TreeNode parent){
            city = c;
            this.parent = parent;
            sub = new HashSet<TreeNode>();
            subcitys = new HashSet<Integer>();
            for(int i = 0; i < map.length; i += 1){
                if(parent != null && parent.city == i) continue;
                if(map[c][i]){
                    TreeNode p = new TreeNode(i,map,this);
                    sub.add(p);
                    subcitys.add(i);
                    subcitys.addAll(p.subcitys);
                }
            }
        }

    }
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i += 1){
            int n = in.nextInt();
            boolean[][] tree = new boolean[n][n];
            for(int j = 0; j < n - 1; j += 1){
                int a = in.nextInt();
                int b = in.nextInt();
                tree[a-1][b-1] = true;
                tree[b-1][a-1] = true;
            }
            int m = in.nextInt();
            int[] order = new int[m];
            for(int j = 0; j < m; j += 1){
                order[j] = in.nextInt();
            }
            TreeNode root = new TreeNode(0,tree, null);
            if(solve(root, n, order)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static boolean solve(TreeNode root,int n, int[] order){
        int m = order.length;
        int[] visited = new int[n];
        int order_p = 0;
        TreeNode city = root;
        visited[0] = 1;
        if(order[order_p] == city.city + 1){
            order_p += 1;
        }
        while (city != null){
            HashSet<TreeNode> nodes_0 = new HashSet<TreeNode>();
            for(TreeNode t:city.sub){
                if(visited[t.city] == 0){
                    nodes_0.add(t);
                }
            }
            if(nodes_0.isEmpty()){
                visited[city.city] = 2;
                city = city.parent;
            }else {
                TreeNode next = null;
                for (TreeNode t: nodes_0){
                    if(t.city == order[order_p] - 1 || t.subcitys.contains(order[order_p]-1)){
                        next = t;
                        break;
                    }
                }
                if(next == null){
                    next = nodes_0.iterator().next();
                }
                if(next.city == order[order_p] - 1){
                    order_p += 1;
                    if(order_p == m) return true;
                }
                city = next;
                visited[city.city] = 1;
            }
        }
        return false;
    }
}
