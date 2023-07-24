package boj1927;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 연산 개수

        while(N-->0){
            int x = Integer.parseInt(br.readLine());    // 입력된 연산

            if(x == 0){ // 0 입력 : 가장 작은 값 출력 후 제거
                if(minHeap.isEmpty()) // 큐가 비어있는데 0 입력한 경우
                    System.out.println(0);

                else{
                    System.out.println(minHeap.poll());
                }
            }

            else{   // 자연수 입력 : 값 추가
                minHeap.offer(x);
            }
        }

    }
}
