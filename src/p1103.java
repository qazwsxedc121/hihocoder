import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by Administrator on 2015/5/30.
 */
public class p1103 {
    public static void main(String[] args) throws IOException {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[]{0,0,0};
        while(i < s.length()){
            int t = token(s, i);
            switch (t){
                case 0:
                    if(!stack.empty() && s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                        res[stack.peek() - 1] += 1;
                    }
                    i += 1;
                    break;
                case 1:
                    stack.push(3);
                    i += 6;
                    break;
                case 2:
                    stack.push(2);
                    i += 8;
                    break;
                case 3:
                    stack.push(1);
                    i += 5;
                    break;
                case 4:
                        stack.pop();
                    i += 7;
                    break;
                case 5:
                        stack.pop();
                    i += 9;
                    break;
                case 6:
                        stack.pop();
                    i += 6;
                    break;
                default:
                    break;
            }
        }
        System.out.printf("%d %d %d\n", res[0], res[1], res[2]);
    }
    private static int token(String s, int from){
        int n = s.length();
        if(n - from >= 6 && s.substring(from, from+6).equals("<blue>")){
            return 1;
        }else if(n - from >= 8 && s.substring(from, from+8).equals("<yellow>")){
            return 2;
        }else if(n - from >= 5 && s.substring(from, from+5).equals("<red>")){
            return 3;
        }else if(n - from >= 7 && s.substring(from, from+7).equals("</blue>")){
            return 4;
        }else if(n - from >= 9 && s.substring(from, from+9).equals("</yellow>")){
            return 5;
        }else if(n - from >= 6 && s.substring(from , from+6).equals("</red>")){
            return 6;
        }
        return 0;
    }
}
