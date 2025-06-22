package boj12865;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 물품의 수
        int K = Integer.parseInt(st.nextToken());   // 가방의 무게

        int weight [] =  new int [N+1];
        int value [] = new int [N+1];
        int dp[][] = new int [N+1][K+1];    // 2차원 배열 선언

        for(int i = 1; i <= N; i ++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        // i : 물건, j = 담을수있는 최대 무게
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                // 물건을 담을 수 없을 때 : i-1값 그대로 내리기
                if(j < weight[i])
                    dp[i][j] = dp[i-1][j];

                // 물건을 담을 수 있을 때 : j-1값 또는 [i-1][j-현재물건무게] + 현재물건 가치
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}


