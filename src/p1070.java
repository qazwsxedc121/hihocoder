/**
 * Created by Administrator on 2015/6/18.
 */

import java.util.*;

public class p1070 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i += 1){
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();
        for(int i = 0; i < m; i += 1){
            int op = in.nextInt();
            if(op == 0){
                int l = in.nextInt() - 1;
                int r = in.nextInt() - 1;
                int res = 10000;
                for(int j = l; j < r + 1; j += 1){
                    if(arr[j] < res){
                        res = arr[j];
                    }
                }
                System.out.println(res);
            }else if(op == 1){
                int index = in.nextInt() - 1;
                int edit = in.nextInt();
                arr[index] = edit;
            }
        }
    }
}