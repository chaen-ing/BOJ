package boj2468;
import java.io.*;
import java.util.*;

public class Main {
    static int [][]map;
    static boolean [][]visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1}; // 순서대로 상 하 좌 우

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // N*N 행렬

        map = new int[N][N];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){ // 행렬에 높이정보 저장
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;

                if(h > max) // 최대값, 최솟값 설정
                    max = h;
                if(h < min)
                    min = h;

            }
        }

        System.out.println(countSafeArea(min, max, N));
    }

    static int countSafeArea(int min, int max, int N){ // 물이 온 높이에 따른 최대 안전 영역 개수 찾기
        int maxNum = Integer.MIN_VALUE; // 최대 안전 영역 개수

        for(int i = min-1; i < max+1; i++){ // 모든 곳이 물에 안잠긴 경우 ~ 모든 곳이 물에 잠긴 경우까지 실행
            int n = findSafeArea(i, N);    // n : 안전 지역 개수
            if(n > maxNum)
                maxNum = n;
        }

        return maxNum;
    }

    static int findSafeArea(int h, int N){  // 주어진 h에 대해 안전 지역 개수를 구해서 리턴, bfs
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[N][N];
        int cnt = 0;

        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                if(map[row][col] > h && !visited[row][col]){    // 안전영역이고 방문한 적 없음
                    Node node = new Node(row,col);  // 시작 노드 설정
                    q.offer(node);
                    cnt++;

                    while(!q.isEmpty()){
                        node = q.poll();

                        for(int k = 0; k < 4; k++){ // 상하좌우 탐색
                            int DC = node.col + dc[k];
                            int DR = node.row + dr[k];

                            if(DC < 0 || DR < 0 || DC >= N || DR >= N){ // 범위초과
                                continue;
                            }

                            if(map[DR][DC] > h && !visited[DR][DC]){    // 안전 영역이고 방문한적 없음
                                q.offer(new Node(DR,DC));
                                visited[DR][DC] = true;
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
    int row, col;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}