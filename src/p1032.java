import java.util.Scanner;

/**
 * User: guoxc
 * Date: 15-3-26
 * Time: 16:53
 */
public class p1032 {
    private static String expandString(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder(n * 2 + 1);
        sb.append('^');
        for(int i = 0; i < n; i += 1){
            sb.append(s.charAt(i));
            sb.append('^');
        }
        return sb.toString();
    }
    private static int LongestAt(String s, int j, int start){
        int i = 0;
        int l = j;
        int r = j;
        for(i = start;; i += 1){
            l = j - i;
            r = j + i;
            if(l == -1 || r == s.length()){
                break;
            }
            if(s.charAt(l) != s.charAt(r)){
                break;
            }
        }
        return 2*i - 1;
    }
    public static int longestSub(String s){
        String sx = expandString(s);
        int n = sx.length();
        int[] dp = new int[n];
        int max_dp = 1;
        int max_f = 0;
        int max_f_i = 0;
        dp[0] = 1;
        for(int i = 1; i < n; i += 1){
            int start = 0;
            if(2 * max_f_i - i > 0) {
                start = Math.min(dp[2 * max_f_i - i], dp[max_f_i] - 2 * (i - max_f_i));
                start = start / 2;
            }
            if(start < 0) start = 0;
            dp[i] = LongestAt(sx, i, start);
            max_dp = Math.max(dp[i],max_dp);
            if(i + dp[i] / 2> max_f){
                max_f = i + dp[i] / 2;
                max_f_i = i;
            }
        }
        return max_dp / 2;
    }
    public static void m(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i += 1){
            String s = in.next();
            System.out.println(longestSub(s));
        }
    }

    public static void test(){
        System.out.println(longestSub("aaaaaaa"));
        System.out.println(longestSub("acacdas"));
    }
}
