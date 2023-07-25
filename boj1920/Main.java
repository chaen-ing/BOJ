package boj1920;
import java.util.*;
import java.io.*;

public class Main {
    static int [] arr;
    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());    // 배열에 값 저장
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);   // 오름차순 정렬

        int M = Integer.parseInt(br.readLine());    // 찾을 값 개수

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            boolean res = binarySearch(Integer.parseInt(st.nextToken()),N);

            if(res)
                System.out.println(1);
            else
                System.out.println(0);

        }

    }

    public static boolean binarySearch(int key,int N){  // 이진탐색
        int low = 0;
        int high = N-1;
        int mid;

        while(low <= high){
            mid = (low + high) / 2;

            if(key < arr[mid])
                high = mid - 1;
            else if(key > arr[mid])
                low = mid + 1;
            else
                return true;    // 같은 경우
        }

        return false;   // 찾는 수가 없을 때
    }
}
