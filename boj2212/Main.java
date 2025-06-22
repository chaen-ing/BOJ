package boj2212;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 센서 개수
        int K = Integer.parseInt(br.readLine());    // 집중국 개수

        // 센서가 하나인 경우 또는 센서보다 집중국 개수가 많은 경우 처리
        if(N==1 || N <= K){
            System.out.println(0);
            return;
        }

        int [] sensors = new int[N];    // 센서 위치
        Integer [] arr = new Integer[N-1];  // 센서 간 간격

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sensors[i] = Integer.parseInt(st.nextToken());  // 센서 위치 입력
        }

        Arrays.sort(sensors);   // 센서 위치 오름차순 정렬

        int sum = 0;
        for(int i = 0; i < N-1; i++){
            arr[i] = sensors[i+1] - sensors[i];   // 센서 간의 간격 입력
            sum += arr[i];
        }

        Arrays.sort(arr,Collections.reverseOrder());    // 센서 간의 간격 내림차순 정렬

        // 간격이 큰 구간부터 제외
        // k(집중국개수)-1개 만큼 제외하면 k개의 구간이 생김
        for(int i = 0; i < K-1; i++){
            sum -= arr[i];
        }

        System.out.println(sum);

    }
}
