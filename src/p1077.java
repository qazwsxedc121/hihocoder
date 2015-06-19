import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/6/19.
 */
public class p1077 {
    static class TreeNode{
        public int left;
        public int right;
        public int val;
        public TreeNode lsub;
        public TreeNode rsub;
        public boolean isLeaf;
        public TreeNode(int [] arr, int l, int r){
            left = l;
            right = r;
            if(l == r){
                val = arr[l];
                isLeaf = true;
            }else{
                int mid = (l + r) / 2;
                lsub = new TreeNode(arr, l, mid);
                rsub = new TreeNode(arr, mid + 1, r);
                val = Math.min(lsub.val, rsub.val);
                isLeaf = false;
            }
        }
        public void edit(int index, int v){
            if(isLeaf){
                val = v;
            }else {
                int mid = (left + right) / 2;
                if(index <= mid){
                    lsub.edit(index, v);
                }else {
                    rsub.edit(index, v);
                }
                val = Math.min(lsub.val, rsub.val);
            }
        }
        public int getMin(int l, int r){
            if(l == left && r == right){
                return val;
            }
            int mid = (left + right) / 2;
            if(r <= mid){
                return lsub.getMin(l,r);
            }else if(l >= mid + 1){
                return rsub.getMin(l,r);
            }else{
                return Math.min(lsub.getMin(l,mid), rsub.getMin(mid+1, r));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(inb.readLine());
        int[] arr = new int[n];
        String[] nums = inb.readLine().split(" ");
        for(int i = 0; i < n; i += 1){
            arr[i] = Integer.parseInt(nums[i]);
        }
        TreeNode root = new TreeNode(arr, 0, n - 1);
        int m = Integer.parseInt(inb.readLine());
        for(int i = 0; i < m; i += 1){
            String[] ops = inb.readLine().split(" ");
            int op = Integer.parseInt(ops[0]);
            if(op == 0){
                int a = Integer.parseInt(ops[1]) - 1;
                int b = Integer.parseInt(ops[2]) - 1;
                System.out.println(root.getMin(a, b));
            }else if(op == 1){
                int index = Integer.parseInt(ops[1]) - 1;
                int v = Integer.parseInt(ops[2]);
                root.edit(index, v);
            }
        }
    }

}
