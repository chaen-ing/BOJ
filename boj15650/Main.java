package boj15650;


import java.io.*;
import java.util.*;

public class Main {

    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    static int N,M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1,0);
        System.out.println(sb);

    }
    public static void dfs(int at, int depth){  // at : 현재위치, depth : 깊이
        if(depth == M){
            for(int i : arr){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 반복문 돌며 배열에 값을 넣어줌
        for(int i = at; i <= N; i++){
            arr[depth] = i;
            dfs(i+1, depth+1);
        }

    }
}

