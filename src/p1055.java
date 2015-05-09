import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/5/9.
 */
public class p1055 {
    private static class TreeNode{
        public List<TreeNode> sub;
        public int label;
        public TreeNode(int l){
            label = l;
            sub = new ArrayList<TreeNode>();
        }
    }
    private static int n;
    private static int m;
    private static int[] v;
    private static TreeNode[] nodes;
    private static int[][] f;
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        v = new int[n];
        nodes = new TreeNode[n];
        for(int i = 0; i < n; i += 1){
            v[i] = in.nextInt();
            nodes[i] = new TreeNode(i);
        }
        for(int i = 0; i < n - 1; i += 1){
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            nodes[a].sub.add(nodes[b]);
        }
        f = new int[n][m+1];
        for(int i = 0; i < n; i += 1){
            f[i][0] = 0;
            f[i][1] = v[i];
        }
        traverse(nodes[0]);
        System.out.println(f[0][m]);
    }
    private static void traverse(TreeNode node){
        for(TreeNode child : node.sub){
            traverse(child);
        }
        for(TreeNode child : node.sub) {
            for(int i = m; i > 1; i -= 1) {
                for (int j = 1; j < i; j += 1) {
                    f[node.label][i] = Math.max(f[node.label][i], f[node.label][i - j] + f[child.label][j]);
                }
            }
        }

    }
}
