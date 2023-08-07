package boj10026;
import java.io.*;
import java.util.*;

public class Main {
    static char [][] RGB;
    static int [] dRow = {0,0,-1,+1};
    static int [] dCol = {-1,+1,0,0};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        RGB = new char [N][N];

        for(int i = 0; i < N; i ++){
            RGB[i] = br.readLine().toCharArray();
        }

        System.out.println(normal(N)+" "+rgWeakness(N));

    }

    static int normal(int N){
        boolean [][] visited = new boolean [N][N];
        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] == true){  // 이미 방문한 노드면 패스
                    continue;
                }

                Queue<Node> q = new LinkedList<>();

                // 초기 노드 설정
                char C = RGB[i][j];
                q.offer(new Node(i,j));
                visited[i][j] = true;

                while(!q.isEmpty()){    // 큐가 공백이 되기 전까지 실행
                    Node node = q.poll();

                    for(int k = 0; k < dCol.length; k++){
                        int row = node.row + dRow[k];
                        int col = node.col + dCol[k];

                        // 범위 초과
                        if(row < 0 || col < 0 || row >= N || col >= N){
                            continue;
                        }

                        // 같은 색이고 방문한적 없을시 큐에 넣기
                        if(RGB[row][col] == C && !visited[row][col]){
                            q.offer(new Node(row,col));
                            visited[row][col] = true;
                        }
                    }
                }
                cnt++;

            }
        }

        return cnt;
    }

    static int rgWeakness(int N){
        boolean [][] visited = new boolean [N][N];
        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] == true){  // 이미 방문한 노드면 패스
                    continue;
                }

                Queue<Node> q = new LinkedList<>();

                // 초기 노드 설정
                char C = RGB[i][j];
                q.offer(new Node(i,j));
                visited[i][j] = true;

                // C가 빨강이나 초록인 경우
                if(C == 'R' || C == 'G'){
                    while(!q.isEmpty()){    // 큐가 공백이 되기 전까지 실행
                        Node node = q.poll();

                        for(int k = 0; k < dCol.length; k++){
                            int row = node.row + dRow[k];
                            int col = node.col + dCol[k];

                            // 범위 초과
                            if(row < 0 || col < 0 || row >= N || col >= N){
                                continue;
                            }

                            // 적색 또는 녹색이고 방문한적 없을시 큐에 넣기
                            if((RGB[row][col] == 'R' || RGB[row][col] == 'G') && !visited[row][col]){
                                q.offer(new Node(row,col));
                                visited[row][col] = true;
                            }
                        }
                    }
                }

                // C가 파랑인 경우
                else{
                    while(!q.isEmpty()){    // 큐가 공백이 되기 전까지 실행
                        Node node = q.poll();

                        for(int k = 0; k < dCol.length; k++){
                            int row = node.row + dRow[k];
                            int col = node.col + dCol[k];

                            // 범위 초과
                            if(row < 0 || col < 0 || row >= N || col >= N){
                                continue;
                            }

                            if(RGB[row][col] == 'B' && !visited[row][col]){
                                    q.offer(new Node(row,col));
                                    visited[row][col] = true;
                            }
                        }
                    }
                }
                cnt++;

            }
        }

        return cnt;
    }
}

class Node{
    int row, col;

    Node(int row, int col){
        this.col = col;
        this.row = row;
    }
}
