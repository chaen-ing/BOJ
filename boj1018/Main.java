package boj1018;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 행
        int M = Integer.parseInt(st.nextToken());   // 열

        char [][] chess = new char[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                chess[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        int min = Integer.MAX_VALUE;
        int minW;
        int minB;

        for(int nStart = 0; nStart < N-7; nStart++){
            for(int mStart = 0; mStart < M-7; mStart++){
                minW = 0;
                cnt = 0;
                // W로 시작하는 경우
                for(int i = nStart; i < nStart + 8; i++){
                    for(int j = mStart; j < mStart + 8; j++){
                        if(cnt % 2 == 0){
                            if(chess[i][j] != 'W') minW++;
                        }else{
                            if(chess[i][j] != 'B') minW++;
                        }
                        cnt++;
                    }
                    cnt--;
                }
                // B로 시작하는 경우
                minB = 0;
                cnt = 0;
                for(int i = nStart; i < nStart + 8; i++){
                    for(int j = mStart; j < mStart + 8; j++){
                        if(cnt % 2 == 0){
                            if(chess[i][j] != 'B') minB++;
                        }else{
                            if(chess[i][j] != 'W') minB++;
                        }
                        cnt++;
                    }
                    cnt--;
                }

                int temp = Math.min(minW,minB);
                min = Math.min(min,temp);
            }
        }

        System.out.println(min);
    }
}
