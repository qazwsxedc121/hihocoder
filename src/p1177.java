
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * User: guoxc
 * Date: 15-6-15
 * Time: 20:44
 */
public class p1177 {
    public static void main(String[] args) {
        HashSet<Integer> remain = new HashSet<Integer>();
        for(int i = 0; i < 52; i += 1){
            remain.add(i);
        }

        int[] points = new int[5];
        int[] kinds = new int[5];

        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 4; i += 1){
            int card = cardReader(in.next());
            remain.remove(card);
            points[i] = card % 13;
            kinds[i] = card / 13;
        }

        int good = 0;
        for(Integer i : remain){
            points[4] = i % 13;
            kinds[4] = i / 13;
            if(isStraight(points, kinds)){
                good += 1;
            }
        }

        if(good == 0){
            System.out.println("0/1");
        }else{
            int g = gcd(good, 48);
            System.out.println((good / g) + "/" + (48 / g));
        }

    }
    private static int gcd(int a, int b){
        int r = b % a;
        while(r != 0){
            b = a;
            a = r;
            r = b % a;
        }
        return a;
    }
    private static int cardReader(String s){
        char kindC = s.charAt(s.length() - 1);
        int kind;
        switch (kindC){
            case 'S':
                kind = 0;
                break;
            case 'H':
                kind = 1;
                break;
            case 'C':
                kind = 2;
                break;
            case 'D':
                kind = 3;
                break;
            default:
                kind = 0;
        }
        String pointS = s.substring(0, s.length() - 1);
        int point;
        if(pointS.equals("A")){
            point = 0;
        }else if(pointS.equals("J")){
            point = 10;
        }else if(pointS.equals("Q")){
            point = 11;
        }else if(pointS.equals("K")){
            point = 12;
        }else{
            point = Integer.parseInt(pointS) - 1;
        }
        return point + (kind * 13);
    }
    private static boolean isStraight(int[] points, int[] kinds){
        boolean[] bitset = new boolean[4];
        for(int i = 0; i < 5; i += 1){
            bitset[kinds[i]] = true;
        }
        int c = 0;
        for(int i = 0; i < 4; i += 1){
            if(bitset[i]) c += 1;
        }
        if(c == 1) return false;
        int[] pointsC = new int[5];
        for(int i = 0; i < 5; i += 1){
            pointsC[i] = points[i];
        }
        Arrays.sort(pointsC);
        int k = pointsC[0];
        if(k == 0 && pointsC[1] == 9){
            k = 8;
        }
        for(int i = 1; i < 5; i += 1){
            k += 1;
            if(pointsC[i] != k) return false;
        }
        return true;
    }
}
