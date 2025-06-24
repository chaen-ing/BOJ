package boj11659;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        secondSolve();
    }

    private static void firstSolve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] accSum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        accSum[0] = 0;
        accSum[1] = Integer.parseInt(st.nextToken());

        for(int i = 2; i < N+1; i++){
            accSum[i] = accSum[i-1] + Integer.parseInt(st.nextToken());
        }

        while(M --> 0){
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int sum = accSum[j] - accSum[i-1];

            bw.write(sum+"");
            bw.newLine();
        }

        bw.flush();
    }

    private static void secondSolve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수의 개수
        int M = Integer.parseInt(st.nextToken());   // 질문 개수

        int [] arr = new int [N];
        int [] sumArr = new int [N];
        st = new StringTokenizer(br.readLine());

        // 첫번째 인덱스
        int k = Integer.parseInt(st.nextToken());
        arr[0] = k;
        sumArr[0] = k;

        // 구간합 배열도 같이 생성
        for(int i = 1; i < N; i++){
            k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            sumArr[i] = sumArr[i-1] + k;
        }

        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 2;
            int end = Integer.parseInt(st.nextToken()) - 1;

            int answer;
            if(start == -1){
                answer = sumArr[end];
            }else{
                answer = sumArr[end] - sumArr[start];
            }

            bw.write(answer + "\n");
        }

        bw.flush();
    }
}
