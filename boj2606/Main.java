// 2606 : 바이러스
package boj2606;
import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> network = new LinkedList<>(); // 링크드 리스트 안에 링크드 리스트 형태
    static boolean[] visited;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int E = Integer.parseInt(br.readLine()); // 간선 개수

        visited = new boolean[N+1];

        for(int i = 0; i < N+1; i++){ // 컴퓨터 N번까지 링크드 리스트 생성
            network.add(new LinkedList<>());
        }

        for(int i = 0; i < E; i++){ // 양방향 연결리스트
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            network.get(a).add(b);
            network.get(b).add(a);
        }

        System.out.println(bfs(N,E));
    }

    static int bfs(int N, int E){ // 너비우선탐색. 큐로 구현
        Queue<Integer> queue = new LinkedList<>();
        int node = 1; // 1번 컴퓨터에서 시작
        visited[node] = true;
        queue.add(node);

        int cnt = 0; // 방문한 노2드개수 저장
        int k;

        while(!queue.isEmpty()){
            node = queue.poll(); // 맨앞의 노드 가져옴

            for(int i = 0; i < network.get(node).size(); i++){ // 각 노드의 크기만큼 탐색
                k = network.get(node).get(i);

                if(visited[k]){ // 방문한적 있는 노드일때
                    continue;
                }

                queue.offer(k); // 방문한 적 없는 노드일때
                visited[k] = true;
                cnt++;

            }
        }

    return cnt;
    }
}
