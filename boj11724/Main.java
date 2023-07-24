package boj11724;
import java.io.*;
import java.util.*;

public class Main {
    static List<LinkedList<Integer>> l = new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점 개수
        int M = Integer.parseInt(st.nextToken());   // 간선 개수

        for(int i = 0; i < N+1; i++){
            l.add(new LinkedList<>());  // 링크드 리스트 안에 링크드 리스트 추가
        }

        for(int i = 0; i < M; i++){ // 그래프 초기화
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            l.get(a).add(b);    // 방향 없는 그래프
            l.get(b).add(a);
        }

        System.out.println(countElement(N,M));


    }
    static int countElement(int N, int M){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;    // 연결요소 개수 카운트

        boolean[] visited = new boolean[N+1];   // 방문여부 체크

        for(int i = 1 ; i < N+1; i++){
            if(visited[i])  // 방문한적 있을 때
                continue;

            // 방문한 적 없을 때
            q.add(i);
            visited[i] = true;

            while(!q.isEmpty()){    // 하나의 연결 요소를 찾으면 종료
                int node = q.poll();

                for(int j = 0; j < l.get(node).size(); j++){
                    int k = l.get(node).get(j); // 현재 노드

                    if(!visited[k]){
                        q.add(k);
                        visited[k] = true;
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
