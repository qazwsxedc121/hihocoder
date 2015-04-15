import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/15.
 */
public class p1050 {
    private static class TreeNode{
        public int val;
        public ArrayList<TreeNode> sub;
        public TreeNode(int v){
            val = v;
            sub = new ArrayList<TreeNode>();
        }
    }
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeNode[] list = new TreeNode[n];
        first = new int[n];
        second = new int[n];
        for(int i = 0; i < n-1; i += 1){
            int a = in.nextInt();
            int b = in.nextInt();
            if(list[a-1] == null && list[b-1] == null){
                list[a-1] = new TreeNode(a);
                list[b-1] = new TreeNode(b);
                list[a-1].sub.add(list[b-1]);
            }else if(list[a-1] == null){
                list[a-1] = new TreeNode(a);
                list[b-1].sub.add(list[a-1]);
            }else if(list[b-1] == null){
                list[b-1] = new TreeNode(b);
                list[a-1].sub.add(list[b-1]);
            }else {
                System.out.println("ERROR");
            }
        }
        maxL = 0;
        traverse(list[0]);
        System.out.println(maxL);
    }
    private static int[] first;
    private static int[] second;
    private static int maxL;
    private static void traverse(TreeNode root){
        if(root.sub.isEmpty()){
            return;
        }else if(root.sub.size() == 1) {
            traverse(root.sub.get(0));
            first[root.val - 1] = first[root.sub.get(0).val - 1] + 1;
            if(first[root.val-1] > maxL){
                maxL = first[root.val-1];
            }
            return;
        }
        int max1 = 0;
        int max2 = 0;
        for(TreeNode t: root.sub){
            traverse(t);
            int v = first[t.val-1];
            if(v >= max1){
                max2 = max1;
                max1 = v;
            }else if(v >= max2){
                max2 = v;
            }
        }
        if(max1 + max2 + 2 > maxL){
            maxL = max1 + max2 + 2;
        }
        first[root.val-1] = max1+1;
        second[root.val-1] = max2+1;
    }
}
