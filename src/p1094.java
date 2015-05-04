import java.util.Scanner;

/**
 * Created by Administrator on 2015/5/4.
 */
public class p1094 {
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] map = new char[n][m];
        for(int i = 0; i < n; i += 1){
            map[i] = in.next().toCharArray();
        }
        char[][] pat = new char[3][3];
        for(int i = 0; i < 3; i += 1){
            pat[i] = in.next().toCharArray();
        }
        for(int i = 0; i < n - 2; i += 1){
            for(int j = 0; j < m - 2; j += 1){
                if(match(map,pat,i,j)){
                    System.out.println((i+2) + " " + (j+2));
                }
            }
        }
    }
    private static boolean match(char[][] map, char[][] pattern, int x, int y){
        boolean flag = true;
        for(int i = 0; i < 3; i += 1){
            for(int j = 0; j < 3; j += 1){
                if(map[x+i][y+j] != pattern[i][j]){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        if(flag){
            return true;
        }
        flag = true;
        for(int i = 0; i < 3; i += 1){
            for(int j = 0; j < 3; j += 1){
                if(map[x+i][y+j] != pattern[j][2-i]){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        if(flag){
            return true;
        }
        flag = true;
        for(int i = 0; i < 3; i += 1){
            for(int j = 0; j < 3; j += 1){
                if(map[x+i][y+j] != pattern[2-i][2-j]){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        if(flag){
            return true;
        }
        flag = true;
        for(int i = 0; i < 3; i += 1){
            for(int j = 0; j < 3; j += 1){
                if(map[x+i][y+j] != pattern[2-j][i]){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        if(flag){
            return true;
        }
        return false;
    }
}
