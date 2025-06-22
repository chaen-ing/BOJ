package boj17087;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 동생 수

        int [] arr = new int[N+1];
        arr[0] = Integer.parseInt(st.nextToken());   // 수빈이 위치

        // 동생들 위치
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int max = 0;

        int [] subArr = new int[N];
        for(int i = 0; i < N; i++){
            subArr[i] = arr[i+1] - arr[i];
            if(i == 0){
                max = subArr[i];
                continue;
            }
            max = getGCD(subArr[i],max);
        }

        System.out.println(max);

    }

    static int getGCD(int a, int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }

        while(a % b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }
}
