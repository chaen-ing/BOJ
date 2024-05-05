package boj11727;

import java.io.*;
import java.util.*;

public class Main {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[1001];

        Arrays.fill(arr,-1);
        arr[1] = 1;
        arr[2] = 3;

        System.out.println(dp(n));
    }
    static int dp(int n){
        if(arr[n] != -1)    return arr[n];
        else{
            arr[n] = (dp(n-1) + dp(n-2) * 2) % 10007;
        }
        return arr[n];
    }
}
