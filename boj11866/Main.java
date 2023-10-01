package boj11866;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue <Integer> q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        sb.append("<");

        for(int i = 1; i <= N ; i++){
            q.offer(i);
        }

        int cnt = 0;
        while(q.size() > 1){
            int top = q.poll();
            cnt++;
            if(cnt == K){
                sb.append(top).append(", ");
                cnt = 0;
            }else{
                q.offer(top);
            }
        }

        sb.append(q.poll()).append(">");
        System.out.println(sb);



    }
}
