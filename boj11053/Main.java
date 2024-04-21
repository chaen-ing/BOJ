package boj11053;

import java.io.*;
import java.util.*;

public class Main {
    static int [] arr;
    static int [] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dist = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dist,1);

        LTS(n);
        System.out.println(Arrays.stream(dist).max().getAsInt());

    }

    static void LTS(int n){

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dist[i] = Math.max(dist[i],dist[j] + 1);
                }
            }
        }
    }
}
