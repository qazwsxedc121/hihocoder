/**
 * User: guoxc
 * Date: 15-3-24
 * Time: 11:02
 */
import java.util.Scanner;
public class p1014 {
    static class TrieNode{
        public TrieNode[] next;
        public int count;
        public int subcount;
        public TrieNode(){
            next = new TrieNode[26];
            count = 0;
            subcount = 0;
        }
        public void insert(String s, int offset){
            if(s.length() == offset){
                count += 1;
            }else{
                int c = s.charAt(offset) - 'a';
                if(next[c] == null){
                    next[c] = new TrieNode();
                }
                next[c].insert(s, offset + 1);
                subcount += 1;
            }
        }
        public int search(String s, int offset){
            if(s.length() == offset){
                return count + subcount;
            }else{
                int c = s.charAt(offset) - 'a';
                if(next[c] == null){
                    return 0;
                }else{
                    return next[c].search(s, offset+1);
                }
            }
        }
    }
    public static void test(String[] args) {
        Scanner in = new Scanner(System.in);
        TrieNode t = new TrieNode();
        int n = in.nextInt();
        for(int i = 0; i < n; i += 1){
            String s = in.next();
            t.insert(s,0);
        }
        int m = in.nextInt();
        for(int i = 0; i < m; i += 1){
            String s = in.next();
            System.out.println(t.search(s, 0));
        }
    }
}
