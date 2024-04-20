package boj1149;

import java.io.*;
import java.util.*;

public class Main {
    static int [][] rgbStreet;
    static int [][] rgbCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        rgbStreet = new int[n][3];
        rgbCost = new int[n][3];

        // 비용 입력 받기
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                int cost = Integer.parseInt(st.nextToken());
                rgbStreet[i][j] = cost;
                rgbCost[i][j] = cost;
            }
        }

        System.out.println(findMinimumCost(n));

    }

    static int findMinimumCost(int n){
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                rgbCost[i][j] = rgbStreet[i][j] + Math.min(rgbCost[i-1][(j+1)%3],rgbCost[i-1][(j+2)%3]);
            }
        }

        return Math.min(Math.min(rgbCost[n-1][0], rgbCost[n-1][1]),rgbCost[n-1][2]);
    }
}
