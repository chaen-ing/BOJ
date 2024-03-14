package boj11050;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int res = 1;
        for(int i = N; i > N-K; i--){
            res *= i;
        }

        for(int i = 1; i <= K; i++){
            res /= i;
        }

        if(K == 0) System.out.println(1);
        else System.out.println(res);
    }
}

