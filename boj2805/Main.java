package boj2805;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 나무의 개수
        int M = Integer.parseInt(st.nextToken());    // 필요한 나무의 길이

        int []trees = new int[N];

        long high =  Integer.MIN_VALUE;
        long low = 0;

        st = new StringTokenizer(br.readLine());    // 배열에 나무 길이 저장
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());

            high = Math.max(trees[i],high);
        }

        while(low < high){ // 배열 내부에서 이분 탐색
            long mid = (low+high) / 2;
            long sum = 0;    // 잘린 나무의 양

            for(int i = 0; i < trees.length; i++){
                if(trees[i] > mid)
                    sum += trees[i] - mid;
            }

            if(sum < M)    // 나무가 가져가려는 양보다 적게 잘렸을 때
                high = mid;
            else    // 가져가려는 양보다 많이 잘렸을 때
                low = mid + 1;
        }

        System.out.println(high-1);

    }
}