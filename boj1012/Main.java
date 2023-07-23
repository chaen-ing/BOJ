package boj1012;
import java.io.*;
import java.util.*;

public class Main {
    static boolean [][] map;
    static boolean [][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while(T-->0) { // T번만큼 테스트케이스 반복
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로 길이
            int N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            map = new boolean[N][M];
            visited = new boolean[N][M];

            while (K--> 0) { // map 채우기
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 가로 좌표
                int Y = Integer.parseInt(st.nextToken()); // 세로 좌표

                map[Y][X] = true;
            }

            System.out.println(bfs(N,M));
        }

    }

    static int bfs(int N, int M) {
        int cnt = 0; // 지렁이 개수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) { // 오른쪽, 아래 방향으로 이동동
                if (map[i][j] && !visited[i][j]) { // 배추가 존재하고, 방문한적 없음
                    Queue<Node> queue = new LinkedList<>();
                    Node node = new Node(i, j);
                    queue.offer(node);
                    visited[i][j] = true;
                    cnt++;

                    while(!queue.isEmpty()) { // 큐가 공백일때 종료
                        node = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int dX = node.x + dx[k];
                            int dY = node.y + dy[k];

                            if (dX < 0 || dY < 0 || dX >= N || dY >= M) { // 범위 초과
                                continue;
                            }

                            if (visited[dX][dY]) { // 이미 방문한 배열
                                continue;
                            }

                            if (map[dX][dY]) { // 배추가 심어져 있을때
                                queue.offer(new Node(dX, dY));
                                visited[dX][dY] = true;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
class Node{
    int x,y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
