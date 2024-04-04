package boj11659;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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
}
