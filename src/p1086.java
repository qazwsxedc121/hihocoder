import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/6/4.
 */
public class p1086 {
    static class Node{
        Node left;
        Node right;
        String val;
        public Node(){
            val = "";
        }
        public Node(String v){
            val = v;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Node head = new Node("HEAD");
        Node tail = new Node("TAIL");
        head.right = tail;
        tail.left = head;
        HashMap<String, Node> map = new HashMap<String, Node>();
        for(int i = 0; i < n; i += 1){
            String query = in.next();
            if(map.containsKey(query)){
                System.out.println("Cache");
                Node theNode = map.get(query);
                Node leftNode= theNode.left;
                Node rightNode = theNode.right;
                leftNode.right = rightNode;
                rightNode.left = leftNode;
                head.right.left = theNode;
                theNode.left = head;
                theNode.right = head.right;
                head.right = theNode;
            }else {
                System.out.println("Internet");
                if(map.size() == m){
                    Node removed = map.get(tail.left.val);
                    map.remove(removed.val);
                    tail.left.left.right = tail;
                    tail.left = tail.left.left;
                }
                Node newNode = new Node(query);
                map.put(query, newNode);
                head.right.left = newNode;
                newNode.left = head;
                newNode.right = head.right;
                head.right = newNode;
            }
        }
    }
}
