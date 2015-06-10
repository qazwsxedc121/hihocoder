import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

/**
 * User: guoxc
 * Date: 15-6-10
 * Time: 17:13
 */
public class p1067 {
    static class UnionFindSet{
        static private class Node{
            String name;
            Node u;
            public Node(String s){
                name = s;
            }
        }
        HashMap<String, Node> map;
        public UnionFindSet(){
            map = new HashMap<String, Node>();
        }
        public void connect(String a, String b){
            map.get(a).u = map.get(b);
        }
        public void insert(String s){
            map.put(s, new Node(s));
        }
        public String findPresent(String s){
            Node p = map.get(s);
            while(p.u != null){
                p = p.u;
            }
            map.get(s).u = p;
            return p.name;
        }
    }
    static class NameTreeNode{
        NameTreeNode parent;
        ArrayList<NameTreeNode> sub;
        String name;
        public NameTreeNode(String n){
            name = n;
            sub = new ArrayList<NameTreeNode>();
        }
    }
    private static HashMap<String, NameTreeNode> treeNodeMap;
    private static NameTreeNode root;
    private static HashMap<String, Integer> status;
    private static HashMap<String, ArrayList<String>> q;
    private static HashMap<String, String> answer;
    private static ArrayList<String> order;
    private static UnionFindSet ufs;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ufs = new UnionFindSet();
        status = new HashMap<String, Integer>();
        treeNodeMap = new HashMap<String, NameTreeNode>();
        q = new HashMap<String, ArrayList<String>>();
        answer = new HashMap<String, String>();
        order = new ArrayList<String>();
        for(int i = 0; i < n; i += 1){
            String father = in.next();
            String son = in.next();

            if(!treeNodeMap.containsKey(father)){
                NameTreeNode newNodeFather = new NameTreeNode(father);
                treeNodeMap.put(father, newNodeFather);
                status.put(father, 0);  // white
                q.put(father, new ArrayList<String>());
                ufs.insert(father);
            }
            if(!treeNodeMap.containsKey(son)){
                NameTreeNode newNodeSon = new NameTreeNode(son);
                treeNodeMap.put(son, newNodeSon);
                status.put(son, 0);
                q.put(son, new ArrayList<String>());
                ufs.insert(son);
            }

            treeNodeMap.get(father).sub.add(treeNodeMap.get(son));
            treeNodeMap.get(son).parent = treeNodeMap.get(father);

        }

        root = treeNodeMap.get(treeNodeMap.keySet().iterator().next());
        while(root.parent != null){
            root = root.parent;
        }

        int m = in.nextInt();

        for(int i = 0; i < m; i += 1){
            String aName = in.next();
            String bName = in.next();
            q.get(aName).add(bName);
            q.get(bName).add(aName);
            order.add(aName + " " + bName);
        }
        dfs(root);
        for(String s: order){
            System.out.println(answer.get(s));
        }

    }
    private static void dfs(NameTreeNode p){
        status.put(p.name, 1); // grey
        for(String s: q.get(p.name)){
            if(status.get(s) == 0) continue;
            if(status.get(s) == 1){
                answer.put(p.name + " " + s, s);
                answer.put(s + " " + p.name, s);
            }else{
                String a = ufs.findPresent(s);
                answer.put(p.name + " " + s, a);
                answer.put(s + " " + p.name, a);
            }
        }
        for(NameTreeNode item: p.sub){

            dfs(item);

        }
        status.put(p.name, 2); // black
        if(p.parent != null) {
            ufs.connect(p.name, p.parent.name);
        }
    }


}
