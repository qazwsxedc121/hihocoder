import java.util.Scanner;

/**
 * Created by Administrator on 2015/6/2.
 */
public class p1173 {
    public static void main(String[] args) {
        sgdp = new int[20000];
        for(int i = 1; i < 20000; i += 1){
            sgdp[i] = -1;
        }
        for(int i = 1; i < 10000; i += 1){
            sgdp[i] = sg(i);
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i += 1){
            arr[i] = in.nextInt();
        }
        int res = 0;
        for(int i = 0; i < n; i += 1){
            res = res ^ sg(arr[i]);
        }
        if(res != 0){
            System.out.println("Alice");
        }else {
            System.out.println("Bob");
        }
    }
    private static int[] sgdp;
    private static int sg(int k){
        if(sgdp[k] != -1) return sgdp[k];
        boolean[] bs = new boolean[k*2];
        bs[0] = true;
        for(int i = 1; i < k; i += 1){
            bs[sg(i)] = true;
            bs[sg(i) ^ sg(k-i)] = true;
        }
        int i = 0;
        while (bs[i]){
            i += 1;
        }
        sgdp[k] = i;
        return i;
    }
}
