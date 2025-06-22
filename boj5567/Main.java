package boj5567;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        List<LinkedList<Integer>> l = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 상근이 동기의 수
        int m = Integer.parseInt(br.readLine());    // 리스트 길이

        boolean []visited = new boolean[n+1];   // 방문 여부 체크

        for(int i = 0; i<= n; i++){
            l.add(new LinkedList<>());
        }

        while(m --> 0){ // 양방향 연결리스트 생성
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            l.get(a).add(b);
            l.get(b).add(a);
        }


        int start = 1;  // 상근이는 1번이므로 1번부터 시작
        visited[start] = true;

        int sum = l.get(start).size();    // 방문객 수

        for(int i = 0; i < l.get(start).size(); i++){   // 상근이의 친구들 확인
            int k = l.get(start).get(i);

            visited[k] = true;
            q.offer(k);
        }

        for(int i = 0; i < l.get(start).size(); i++){
            int friend = q.poll();

            for(int j = 0; j < l.get(friend).size(); j++){  // 친구의 친구 탐색
                int k = l.get(friend).get(j);

                if(visited[k])
                    continue;

                visited[k] = true;
                sum++;
            }
        }

        System.out.println(sum);




    }
}
