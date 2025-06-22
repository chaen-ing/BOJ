package boj7562;
import java.io.*;
import java.util.*;

public class Main {
    static boolean [][] chessBoard;
    static boolean [][] visited;
    static int [] dc = {-2,-1,1,2,2,1,-1,-2};
    static int [] dr = {-1,-2,-2,-1,1,2,2,1};


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        while(N-->0){
            int l = Integer.parseInt(br.readLine());    // 행, 열 크기
            chessBoard = new boolean[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());    // 시작 위치 노드
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            Node start = new Node(row,col,0);

            st = new StringTokenizer(br.readLine());    // 끝 위치 노드
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            Node end = new Node(row,col,0);

            if(start.row == end.row && start.col == end.col)    // 시작과 끝이 같을 때
                System.out.println(0);
            else
                System.out.println(countMin(start,end,l));
        }

    }

    static int countMin(Node start, Node end,int l){
        Queue<Node> q = new LinkedList<>();

        q.offer(start); // 시작 노드
        visited[start.row][start.col] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i = 0; i < 8; i++){
                int DC = node.col + dc[i];
                int DR = node.row + dr[i];

                if(DC == end.col && DR == end.row){ // 종료 노드 찾았을 때
                    return node.cnt+1;
                }

                if(DC < 0 || DR < 0 || DC >= l || DR >= l)  // 범위 초과
                    continue;

                if(visited[DR][DC]) // 이미 방문한 노드
                    continue;

                visited[DR][DC] = true;
                q.offer(new Node(DR,DC,node.cnt+1));
            }
        }

        return -1;  // 찾을 수 없을 때
    }
}

class Node{
    int row,col,cnt;

    Node(int row, int col,int cnt){
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}
