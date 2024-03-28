package boj2217;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            max = Math.max(max, arr[i]*(N-i));
        }

        System.out.println(max);


    }
}