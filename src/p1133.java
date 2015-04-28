import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/28.
 */
public class p1133 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i += 1){
            num[i] = in.nextInt();
        }
        int c = 0;
        int l = 0;
        int r = n - 1;
        while (c != k-1){
            c = partition(num, l, r);
            if( c < k-1){
                l = c + 1;
            }else if( c > k-1){
                r = c - 1;
            }
        }
        System.out.println(num[k-1]);
    }
    private static int partition(int[] num, int l, int r){
        int pivot = num[r];
        int p = l;
        for(int i = l; i < r; i += 1){
            if(num[i] < pivot){
                swap(num, i, p);
                p += 1;
            }
        }
        swap(num, p, r);
        return p;
    }
    private static void swap(int[] num, int l, int r){
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}
