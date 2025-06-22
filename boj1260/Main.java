package boj1260;
import java.io.*;
import java.util.*;

public class Main {
    static boolean visited[];
    static LinkedList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new LinkedList[n + 1];

        visited = new boolean[n + 1]; // 방문여부 체크, 디폴트가 false

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new LinkedList<>(); // 링크드 리스트 n개를 리스트에 추가
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b); // a라는 연결리스트를 가져와 b를 추가
            graph[b].add(a);
             // 양방향 그래프이므로 둘다 추가

        }

        for (int i = 1; i < n+1; i++) { // 오름차순 정렬
            Collections.sort(graph[i]);
        }

        for (int i = 1; i < n + 1; i++) { // 끝을 표현해주기위해 연결리스트의 마지막에는 0 삽입
            graph[i].add(0);
        }

        dfs(v,n,m);
        System.out.println();
        visited = new boolean[n+1]; // 방문여부 체크 배열 초기화
        bfs(v,n,m);

    }

    static void dfs(int v,int n, int m){ // 깊이 우선 탐색. 스택으로 구현
        Stack<Integer> stack = new Stack<>();
        visited[v] = true;
        stack.push(v);
        System.out.print(v+" ");

        int num = 0;
        while(stack.size() != 0){
            for(int i = 0; i < m+1; i++){
                num = graph[v].get(i);
                if(num == 0){ // 인접노드가 없을때
                    stack.pop();
                    if(stack.size() == 0){ // 스택이 공백이 되면 종료
                        return;
                    }
                    v = stack.peek();
                    i = -1;
                }
                else if(visited[num] == false){ // 인접노드가 있고 방문하지 않은 노드일때 -> 해당 노드로 이동해서 0번부터 탐색
                    visited[num] = true;
                    stack.push(num);
                    System.out.print(num+" ");
                    v = num;
                    i = -1;
                }

            }

        }

    }

    static void bfs(int v,int n, int m){ // 너비 우선 탐색. 큐로 구현
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true; // 시작 노드
        queue.offer(v);
        System.out.print(v+" ");

        int num = 0;
        while(queue.size() != 0){
            for(int i = 0; i < graph[v].size(); i++){
                num = graph[v].get(i);
                if(num == 0){ // 더 이상 인접노드가 없을때
                    queue.poll();
                    if(queue.size() == 0){ // 인접노드도 없고, 큐도 공백이 되면 종료
                        return;
                    }
                    v = queue.peek();
                    i = -1;
                    // 다음 노드로 이동
                }
                else if(visited[num] == false){ // 방문하지 않은 노드일때 방문 -> 해당 노드의 형제노드 모두 탐색
                    visited[num] = true;
                    queue.offer(num); // 큐에 넣기
                    System.out.print(num+" ");
                }

            }

        }
    }
}


