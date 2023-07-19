// 2606 : 바이러스
package boj2606;
import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer>[] network;
    static boolean[] visited;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int E = Integer.parseInt(br.readLine()); // 간선 개수

        visited = new boolean[N+1];
        network = new LinkedList[N+1];

        for(int i = 0; i < N+1; i++){ // 컴퓨터 N번까지 링크드 리스트 생성
            network[i] = new LinkedList<>();
        }

        for(int i = 0; i < E; i++){ // 양방향 연결리스트
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            network[a].add(b);
            network[b].add(a);
        }

        for(int i = 1; i < N+1; i++){ // 오름차순 정렬, 마지막 의미하는 0 삽입
            Collections.sort(network[i]);
            network[i].add(0);
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

        while(queue.size() != 0){
            for(int i = 0; i < network[node].size(); i++){
                k = network[node].get(i); // 새로 탐색할 노드
                if(k == 0){ // 더이상 탐색할 노드가 없을 때
                    queue.poll();
                    if(queue.size() == 0){ // 큐가 공백이 되면 종료
                        return cnt;
                    }
                    node = queue.peek();
                    i = -1;
                }
                else if(visited[k] == false){ // 방문한적 없는 인접노드
                    visited[k] = true;
                    queue.offer(k);
                    cnt++;
                }
                // 탐색한적 있고 다음 노드가 있을때는 0이 나올때까지 인덱스 넘김
            }
        }

    return cnt;
    };
}
