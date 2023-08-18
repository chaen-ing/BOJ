package boj1158;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder().append("<");

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());   // N명
        int K = Integer.parseInt(st.nextToken());   // K번째

        // 초기 상태 설정
        for(int i = 1; i <= N; i++){
            q1.offer(i);
        }

        boolean isQ1 = true;
        int cnt = 1;
        while(!q1.isEmpty() || !q2.isEmpty()){  // 모든 큐가 공백이 될때까지 실행
            // q1에서 제거중일때
            if(isQ1){
                if(q1.isEmpty()){
                    isQ1 = false;
                    continue;
                }
                if(cnt == K){
                    sb.append(q1.poll()).append(", ");
                    cnt = 1;
                    continue;
                }
                q2.offer(q1.poll());
                cnt++;
            }
            // q2에서 제거중일때
            else{
                if(q2.isEmpty()){
                    isQ1 = true;
                    continue;
                }
                if(cnt == K){
                    sb.append(q2.poll()).append(", ");
                    cnt = 1;
                    continue;
                }
                q1.offer(q2.poll());
                cnt++;
            }
        }
        sb.delete(sb.length()-2,sb.length()).append(">");
        System.out.println(sb);

    }
}
