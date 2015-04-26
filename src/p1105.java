import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/26.
 */
public class p1105 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] heap = new int[n];
        int heap_length = 0;
        for(int i = 0; i < n; i += 1){
            String action = in.next();
            if(action.equals("A")){
                int weight = in.nextInt();
                heapadd(heap, heap_length, weight);
                heap_length += 1;
            }else if(action.equals("T")){
                System.out.println(heap[0]);
                swap(heap, heap_length - 1, 0);
                heap_length -= 1;
                heapify(heap, heap_length, 0);
            }
        }
    }
    private static void heapify(int[] heap,int l,int k){
        int i = k;
        while (i*2 + 1 < l){
            if(i*2 + 2 >= l){
                if(heap[i*2 + 1] > heap[i]){
                    swap(heap, i, i * 2 + 1);
                }
                return;
            }else if(heap[i*2 + 1] > heap[i] || heap[i*2 + 2] > heap[i]){
                if(heap[i*2 + 1] > heap[i*2 + 2]){
                    swap(heap, i, i * 2 + 1);
                    i = i * 2 + 1;
                }else {
                    swap(heap, i, i * 2 + 2);
                    i = i * 2 + 2;
                }
            }else {
                return;
            }
        }
    }
    private static void heapadd(int[] heap, int l, int a){
        heap[l] = a;
        int k = (l - 1) / 2;
        while (k != 0){
            heapify(heap, l + 1, k);
            k = (k - 1) / 2;
        }
        heapify(heap, l + 1, 0);
    }
    private static void swap(int[] heap, int l, int r){
        int temp = heap[l];
        heap[l] = heap[r];
        heap[r] = temp;
    }
}
