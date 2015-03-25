import java.util.Arrays;
import java.util.Scanner;

/**
 * User: guoxc
 * Date: 15-3-25
 * Time: 11:10
 */
public class p1015 {
    static class KMP{
        String pattern;
        int[] pi;
        public KMP(String p){
            pattern = p;
            int n = pattern.length();
            pi = new int[n];
            for(int i = 1; i < n; i += 1){
                char a = p.charAt(i);
                int k = i - 1;
                char ak = p.charAt(pi[k]);

                while(k > 0 && a != ak){
                    k = pi[k] - 1;
                    if(k < 0) break;
                    ak = p.charAt(pi[k]);
                }
                if(a == ak){
                    pi[i] = pi[k] + 1;
                }
            }
        }
        @Override
        public String toString(){
            String res = "P:\"" + pattern + "\" ";
            res += Arrays.toString(pi);
            return res;
        }
        public int match(String s){
            int sn = s.length();
            int pn = pattern.length();
            int res = 0;
            int state = 0;
            for(int i = 0; i < sn; i += 1){
                char c = s.charAt(i);

                if(pattern.charAt(state) == c){
                    state += 1;
                    if(state == pn){
                        state = pi[state-1];
                        res += 1;
                    }
                }else {
                    state = goThough(state,c);
                }
            }
            return res;
        }
        public int goThough(int state, char x){
            while(state > 0 && x != pattern.charAt(state)){
                state = pi[state-1];
            }
            if(state == 0){
                return x == pattern.charAt(0) ? 1 : 0;
            }else{
                return state + 1;
            }

        }
    }
    public static void test(){
        KMP k = new KMP("AABA");
        System.out.println(k);
        System.out.println(k.match("AABAAAAAAABAA") == 2);
        k = new KMP("ABAB");
        System.out.println(k);
        System.out.println(k.match("ABABAAAAAABAB") == 2);
    }
    public static void m(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i += 1){
            String p = in.next();
            String s = in.next();
            KMP kmp = new KMP(p);
            System.out.println(kmp.match(s));
        }
    }

}
