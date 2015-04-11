import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Administrator on 2015/4/11.
 */
public class p1039 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i += 1){
            System.out.println(solve(in.next()));
        }
    }
    public static int solve(String s){
        String s1 = s;
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n + 1; i += 1){
            s1 = s.substring(0,i) + 'A' + s.substring(i, n);
            res = Math.max(res, s1.length() - shrink(s1).length());
            s1 = s.substring(0,i) + 'B' + s.substring(i, n);
            res = Math.max(res, s1.length() - shrink(s1).length());
            s1 = s.substring(0,i) + 'C' + s.substring(i, n);
            res = Math.max(res, s1.length() - shrink(s1).length());
        }
        return res;
    }
    public static String shrink(String s){

        Stack<Character> stack = new Stack<Character>();
        int n = s.length();
        char lastChar = 'x';
        char[] chars = s.toCharArray();
        int chars_p = 0;
        int chars_n = n;
        int chars_no = 0;
        int i = 0;
        while(chars_no != chars_n) {
            chars_p = 0;
            chars_no = chars_n;
            i = 0;
            lastChar = 'x';
            char[] chars2 = new char[n];
            while (i < chars_n) {
                char c = chars[i];
                if (c != lastChar) {
                    chars2[chars_p] = c;
                    chars_p += 1;
                    lastChar = c;
                    i += 1;
                } else {
                    chars_p -= 1;
                    while (i < n && chars[i] == lastChar) {
                        i += 1;
                    }
                }
            }
            chars_n = chars_p;
            chars = chars2;
        }

        String res =  new String(chars).substring(0,chars_n);
        return res;
    }
    public static int longestPalindrome(String s){
        int res = 1;
        int n = s.length();
        if(n == 0){
            return 0;
        }
        for(int i = 0; i < n; i += 1){
            int j = 0;
            while(i - j > -1 && i + j < n && s.charAt(i-j) == s.charAt(i+j)){
                j += 1;
            }
            j -= 1;
            res = Math.max(res, 1 + (2 * j));
        }
        return res;
    }
}
