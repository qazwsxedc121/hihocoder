import java.util.Scanner;

/**
 * Created by Administrator on 2015/4/12.
 */
public class p1040 {
    static class Point{
        public int x;
        public int y;
        public Point(int px, int py){
            this.x = px;
            this.y = py;
        }
        public boolean equals(Point p){
            return this.x == p.x && this.y == p.y;
        }
        public long distance2(Point p){
            return ((long)(x - p.x) * (long)(x - p.x) + (long)(y - p.y) * (long)(y - p.y));
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i += 1){
            Point[] ps = new Point[8];
            for(int j = 0; j < 8; j += 1){
                int x = in.nextInt();
                int y = in.nextInt();
                Point p = new Point(x,y);
                ps[j] = p;
            }
            if(judgeQ(ps)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
    public static boolean judgeQ(Point[] ps){
        Point p0 = ps[0];
        Point p1 = ps[1];
        Point p2 = null;
        Point p3 = null;
        if(p0.equals(p1)) return false;
        boolean[] lineVisited = new boolean[4];
        lineVisited[0] = true;
        int nextL = 0;
        for(int i = 1; i < 4; i += 1){
            if(p1.equals(ps[i*2])){
                lineVisited[i] = true;
                p2 = ps[i*2 + 1];
                break;
            }else if(p1.equals(ps[i*2+1])){
                lineVisited[i] = true;
                p2 = ps[i*2];
                break;
            }
        }
        if(p2 == null || p2.equals(p1) || p2.equals(p0)) return false;
        for(int i = 1; i < 4; i += 1){
            if(!lineVisited[i] && p2.equals(ps[i*2])){
                lineVisited[i] = true;
                p3 = ps[i*2 + 1];
                break;
            }else if(!lineVisited[i] && p2.equals(ps[i*2 + 1])){
                lineVisited[i] = true;
                p3 = ps[i*2];
                break;
            }
        }
        if(p3 == null || p3.equals(p2) || p3.equals(p1) || p3.equals(p0)) return false;
        int rest = 0;
        for(int i = 0; i < 4; i += 1){
            if(lineVisited[i] == false){
                rest = i;
                break;
            }
        }
        if(p0.equals(ps[rest*2])){
            if(!p3.equals(ps[rest*2+1])){
                return false;
            }
        }else if(p0.equals(ps[rest*2+1])){
            if(!p3.equals(ps[rest*2])){
                return false;
            }
        }else{
            return false;
        }
        return judgeS(p0,p1,p2) && judgeS(p1,p2,p3) && judgeS(p2,p3,p0) && judgeS(p3,p0,p1);
    }
    public static boolean judgeS(Point p1, Point p2, Point p3){
        long a2 = p1.distance2(p2);
        long b2 = p2.distance2(p3);
        long c2 = p1.distance2(p3);
        return c2 == a2 + b2;
    }
}
