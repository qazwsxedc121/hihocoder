import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/8.
 */
public class p1128 {
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int[] seq = new int[n+1];
        for(int i = 0; i < n; i += 1){
            seq[i] = in.nextInt();
            if(seq[i] == target){
                flag = true;
            }
        }
        seq[n] = target;
        int x = partition(seq, 0, n);
        if(flag){
            System.out.println(x);
        }else{
            System.out.println(-1);
        }
    }
    public static int partition(int[] seq,int l, int r){
        if(l == r){
            return l;
        }
        int pivot = seq[r];
        int p0 = l;
        for(int i = l; i < r; i += 1){
            if(seq[i] <= pivot){
                swap(seq, i, p0);
                p0 += 1;
            }
        }
        swap(seq, r, p0);
        return p0;

    }
    public static void swap(int[] seq, int a, int b){
        int k = seq[b];
        seq[b] = seq[a];
        seq[a] = k;
    }
}
