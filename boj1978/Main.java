package boj1978;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int PrimeNum = N;
        while(N-->0){
            int n = Integer.parseInt(st.nextToken());
            int sqrt = (int) Math.sqrt(n);

            // 1 세팅
            if(n == 1){
                PrimeNum--;
                continue;
            }

            for(int i = 2; i <= sqrt; i++){
                // 소수가 아닐시 개수에서 제외하고 즉시 종료
                if(n % i == 0){
                    PrimeNum--;
                    break;
                }
            }
        }

        System.out.println(PrimeNum);


    }
}
