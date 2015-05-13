import java.util.Scanner;

/**
 * User: guoxc
 * Date: 15-5-11
 * Time: 18:07
 */
public class p1052 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i += 1){
            String s = in.next();
            int k = in.nextInt();
            System.out.println(solve(k,s));
        }
    }
    private static int solve(int k, String s){
        int n = s.length();
        if(k == n) return 0;
        if(k * 2 <= n){
            return solveSplit(new String[]{s.substring(0,k), s.substring(n-k,n)});
        }else {
            int sublen = n - k;
            int subc = ((n - 1) / sublen) + 1;
            String[] strs = new String[subc];
            for(int i = 0; i < subc - 1; i += 1){
                strs[i] = s.substring(i * sublen, (i + 1) * sublen);
            }
            strs[subc-1] = s.substring((subc - 1) * sublen);
            return solveSplit(strs);
        }

    }
    private static int solveSplit(String[] strs){
        int strlen = strs[0].length();
        int n = strs.length;
        int res = 0;
        for(int i = 0; i < strlen; i += 1){
            char[] chars;
            if(i < strs[n-1].length()){
                chars = new char[n];
                for(int j = 0; j < n; j += 1){
                    chars[j] = strs[j].charAt(i);
                }
                res += solveSingle(chars);
            }else{
                chars = new char[n-1];
                for(int j = 0; j < n - 1; j += 1){
                    chars[j] = strs[j].charAt(i);
                }
                res += solveSingle(chars);
            }
        }
        return res;
    }
    private static int solveSingle(char[] chars){
        int[] cc = new int[4];
        for(int i = 0; i < chars.length; i += 1){
            switch (chars[i]){
                case 'A':
                    cc[0] += 1;
                    break;
                case 'T':
                    cc[1] += 1;
                    break;
                case 'G':
                    cc[2] += 1;
                    break;
                case 'C':
                    cc[3] += 1;
                    break;
                default:
                    break;
            }
        }
        int maxc = 0;
        for(int i = 0; i < 4; i += 1){
            maxc = Math.max(maxc, cc[i]);
        }
        return chars.length - maxc;
    }
}
