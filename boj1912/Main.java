package boj1912;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        int [] maxSum = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){ // 배열에 값들 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];

        maxSum[0] = arr[0];

        for(int i = 1; i < N; i++){ // 해당 위치까지의 최대값
            maxSum[i] = Math.max(maxSum[i-1],0) + arr[i];
            max = Math.max(max, maxSum[i]);
        }

        System.out.println(max);



    }
}
