package boj1929;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 1처리
        if(M==1)
            M++;

        for(int i = M; i <= N; i++){
            boolean primeNum = true;
            // 짝수는 패스, 2는 소수에 포함
            if(i % 2 == 0){
                if(i != 2)
                    continue;
            }
            // 소수 판별
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    primeNum = false;
                    break;
                }
            }
            if(primeNum)
                System.out.println(i);
        }
    }
}
