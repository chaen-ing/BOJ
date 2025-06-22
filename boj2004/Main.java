
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 조합 공식 : nCm = nPm / m! = n! / (n-m)! m!

        int cnt5 = power5(n) - power5(n-m) - power5(m);
        int cnt2 = power2(n) - power2(n-m) - power2(m);

        System.out.println(Math.min(cnt5,cnt2));

    }

    public static int power5(int n){
        int cnt = 0;

        while(n >= 5){
            cnt += n / 5;
            n /= 5;
        }

        return cnt;
    }

    public static int power2(int n){
        int cnt = 0;

        while(n >= 2){
            cnt += n / 2;
            n /= 2;
        }

        return cnt;
    }
}
