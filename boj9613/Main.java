package boj9613;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 개수
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            st = new StringTokenizer(br.readLine());

            // 정수 개수
            int n = Integer.parseInt(st.nextToken());

            int [] arr = new int[n];

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for(int i = 0; i < n-1; i++){
                for(int j = i+1; j < n; j++){
                    sum += getGCD(arr[i],arr[j]);
                }
            }

            System.out.println(sum);
        }
    }

    public static int getGCD(int i, int j){
        // i를 큰걸로 초기화
        if(j > i){
            int temp = i;
            i = j;
            j = temp;
        }

        while(i % j != 0){
            int temp = i % j;
            i = j;
            j = temp;
        }

        return j;
    }
}
