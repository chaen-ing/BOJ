package boj1697;

import java.io.*;
import java.util.*;

public class Main {
    public static int [] DX = {1,-1,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 시작점과 도착점이 같은 경우
        if(N == K){
            System.out.println(0);
            return;
        }

        int [] arr = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        arr[N] = 0;

        while(!queue.isEmpty()){
            int loc = queue.poll();
            int cnt = arr[loc] + 1;

            for(int i = 0; i < 3 ; i++){
                int dx;
                if(i != 2){
                    dx = loc + DX[i];
                }else{
                    dx = loc * DX[i];
                }

                if(dx == K){    // 도착
                    System.out.println(cnt);
                    return;
                }else if(dx < 0 || dx > 100000){   //  범위 초과
                    continue;
                }else if(arr[dx] == 0){
                    arr[dx] = cnt;
                    queue.offer(dx);
                }
            }
        }


    }
}

