package boj1932;

import java.io.*;
import java.util.*;

public class Main {
    static int [][] triangle;
    static int [][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        triangle = new int[n][n];
        dist = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findMaxDist(n));

    }

    static int findMaxDist(int n){
        dist[0][0] = triangle[0][0];

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dist[i][j] = dist[i-1][j] + triangle[i][j];
                }else if(j == i){
                    dist[i][j] = dist[i-1][j-1] + triangle[i][j];
                }else{
                    dist[i][j] = Math.max(dist[i-1][j-1], dist[i-1][j]) + triangle[i][j];
                }
            }
        }

        return Arrays.stream(dist[n-1]).max().getAsInt();
    }
}
