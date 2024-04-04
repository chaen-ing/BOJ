package boj2178;

import java.io.*;
import java.util.*;

public class Main {
    static int [][] maze;
    static int [][] dist;
    static int [] DX = {1,-1,0,0};
    static int [] DY = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        dist = new int[N][M];

        // 미로 입력 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        Queue <Node> queue = new LinkedList<>();

        // 시작 노드
        queue.offer(new Node(0,0));
        dist[0][0] = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int k = 0; k < 4; k++){
                int dx = node.x + DX[k];
                int dy = node.y + DY[k];

                if(dx < 0 || dx >= N || dy < 0 || dy >= M){
                    continue;
                }
                if(maze[dx][dy] == 0){
                    continue;
                }
                if(dist[dx][dy] != 0){
                    continue;
                }

                queue.offer(new Node(dx,dy));
                dist[dx][dy] = dist[node.x][node.y] + 1;

            }
        }

        System.out.println(dist[N-1][M-1]);
    }
}

class Node{
    int x, y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }

}
