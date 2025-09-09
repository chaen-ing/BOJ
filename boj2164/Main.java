package boj2164;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 초기화
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            q.offer(i);
        }

        boolean flag = true;
        while(true){
            if(q.size() == 1){
                System.out.println(q.peek());
                break;
            }

            if(flag){
                q.poll();
                flag = false;
            }else{
                int temp = q.poll();
                q.offer(temp);
                flag = true;
            }

        }












    }

    private void firstTry() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }

        boolean flag = true;
        while(queue.size() > 1){
            if(flag == true){
                queue.poll();
                flag = false;
            }else{
                int m = queue.poll();
                queue.offer(m);
                flag = true;

            }
        }

        System.out.println(queue.peek());

    }
}
