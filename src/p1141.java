import java.util.Scanner;

/**
 * User: guoxc
 * Date: 15-4-25
 * Time: 20:56
 */
public class p1141 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i += 1){
            arr[i] = in.nextInt();
        }
        System.out.println(merge(arr,0,n));
    }
    public static long merge(int[] arr, int l, int r){
        if(l >= r - 1){
            return 0;
        }
        int mid = (l+r)/2;
        long a = merge(arr, l, mid);
        long b = merge(arr, mid, r);
        int[] larr = new int[mid - l];
        int[] rarr = new int[r - mid];
        for(int i = 0; i < mid - l; i += 1){
            larr[i] = arr[l + i];
        }
        for(int i = 0; i < r - mid; i += 1){
            rarr[i] = arr[mid + i];
        }
        long res = a + b;
        int pl = 0;
        int pr = 0;
        while (pl < mid - l && pr < r - mid){
            if(larr[pl] <= rarr[pr]){
                arr[l + pl + pr] = larr[pl];
                pl += 1;
            }else{
                arr[l + pl + pr] = rarr[pr];
                res += mid - l - pl;
                pr += 1;
            }
        }
        while (pl < mid - l){
            arr[l + pl + pr] = larr[pl];
            pl += 1;
        }
        while(pr < r - mid){
            arr[l + pl + pr] = rarr[pr];
            pr += 1;
        }
        return res;
    }
}
