import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/6/17.
 */
public class p1069 {
    static class TreeNode{
        String name;
        List<TreeNode> sub;
        TreeNode parent;
        int level;
        public TreeNode(String n){
            sub = new ArrayList<TreeNode>();
            name = n;
            parent = null;
            level = 0;
        }
    }
    static HashMap<String, TreeNode> nameMapper;
    static ArrayList<String> dfsArray;
    public static void main(String[] args) {
        nameMapper = new HashMap<String, TreeNode>();
        dfsArray = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i += 1){
            String a = in.next();
            String b = in.next();
            if(!nameMapper.containsKey(a)){
                nameMapper.put(a, new TreeNode(a));
            }
            if(!nameMapper.containsKey(b)){
                nameMapper.put(b, new TreeNode(b));
            }
            nameMapper.get(a).sub.add(nameMapper.get(b));
            nameMapper.get(b).parent = nameMapper.get(a);
        }
        TreeNode root = nameMapper.get(nameMapper.keySet().iterator().next());
        while(root.parent != null){
            root = root.parent;
        }
        dfsLevel(root, 0);
        dfs(root);
        int dn = dfsArray.size();
        String[] arr = new String[dn];
        int[] lvl = new int[dn];
        dfsArray.toArray(arr);
        for(int i = 0; i < dn; i += 1){
            lvl[i] = nameMapper.get(arr[i]).level;
        }

        //findLast
        HashMap<String, Integer> lastIndex = new HashMap<String, Integer>();
        for(int i = 0; i < dn; i += 1){
            lastIndex.put(arr[i], i);
        }

        //dp
        int bmax = 1;
        while((1 << bmax) < dn){
            bmax += 1;
        }
        String[][] dp = new String[bmax][dn];
        for(int i = 0; i < dn; i += 1){
            dp[0][i] = arr[i];
        }
        for(int j = 1; j < bmax; j += 1){
            for(int i = 0; i < dn; i += 1){
                if(i + (1<< (j - 1)) < dn) {
                    if(nameMapper.get(dp[j - 1][i]).level < nameMapper.get(dp[j-1][i+(1<<(j - 1))]).level){
                        dp[j][i] = dp[j-1][i];
                    }else{
                        dp[j][i] = dp[j-1][i+(1<<(j - 1))];
                    }
                }else{
                    dp[j][i] = dp[j-1][i];
                }
            }
        }

        int m = in.nextInt();
        for(int i = 0; i < m; i += 1){
            String a = in.next();
            String b = in.next();
            int ai = lastIndex.get(a);
            int bi = lastIndex.get(b);
            int l = ai;
            int r = bi;
            if(ai > bi){
                l = bi;
                r = ai;
            }
            int k = 0;
            while((1 << k) <= (r - l + 1)){
                k += 1;
            }
            k -= 1;
            if(nameMapper.get(dp[k][l]).level < nameMapper.get(dp[k][r - (1 << k) + 1]).level){
                System.out.println(dp[k][l]);
            }else{
                System.out.println(dp[k][r - (1 << k) + 1]);
            }

        }
    }
    private static void dfsLevel(TreeNode root, int level){
        root.level = level;
        for(TreeNode p : root.sub){
            dfsLevel(p, level + 1);
        }
    }
    private static void dfs(TreeNode root){
        dfsArray.add(root.name);
        for(TreeNode p : root.sub){
            dfs(p);
            dfsArray.add(root.name);
        }
    }

}
