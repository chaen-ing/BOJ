package boj1003;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr0;
    static int[] arr1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr0 = new int[41];
        arr1 = new int[41];

        Arrays.fill(arr0,-1);
        Arrays.fill(arr1,-1);

        // 초기화
        arr0[0] = 1;
        arr0[1] = 0;
        arr1[0] = 0;
        arr1[1] = 1;


        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());

            if(arr0[N] == -1)   bw.write(fibonacci0(N)+""+" ");
            else    bw.write(arr0[N]+""+" ");

            if(arr1[N] == -1)   bw.write(fibonacci1(N)+"");
            else    bw.write(arr1[N]+"");

            bw.newLine();
        }
        bw.flush();


    }
    static int fibonacci0(int n){
        if(arr0[n] != -1)   return arr0[n];
        else{
            arr0[n] = fibonacci0(n-1) + fibonacci0(n-2);
        }
        return arr0[n];
    }

    static int fibonacci1(int n){
        if(arr1[n] != -1)   return arr1[n];
        else{
            arr1[n] = fibonacci1(n-1) + fibonacci1(n-2);
        }
        return arr1[n];
    }
}
