package boj7576;

import java.io.*;
import java.util.*;

public class Main {
    static int [][] tomatoMap;
    static Queue<Node> queue;
    static int [] dx  = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());   // 가로
        int N = Integer.parseInt(st.nextToken());   // 세로

        tomatoMap = new int[N][M];

        queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                int tomato = Integer.parseInt(st.nextToken());

                if(tomato == 0){
                    continue;
                }else if(tomato == 1){
                    queue.add(new Node(i,j));   // 시작 노드
                    tomatoMap[i][j] = 1;
                }else if (tomato == -1){    // 못가는 곳
                    tomatoMap[i][j] = -1;
                }
            }
        }

        System.out.println(bfs(N,M));
    }

    static int bfs(int n, int m){
        int cnt = 0;

        while(!queue.isEmpty()){
            cnt++;
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Node node = queue.poll();

                for(int j = 0; j < 4; j++){
                    int rx = node.x + dx[j];
                    int ry = node.y + dy[j];

                    if(rx >= n || rx < 0 || ry >= m || ry < 0 ){
                        continue;
                    }else if(tomatoMap[rx][ry] == 0){
                        tomatoMap[rx][ry] = cnt;
                        queue.add(new Node(rx,ry));
                    }
                }
            }
        }


        if(checkRipe(n,m)){
            return --cnt;   // while문에서 마지막에 갈 곳이 없을때도 cnt++하므로 한번 빼줘야함
        }else{
            return -1;
        }

    }

    // 배열에 0이 있는지 체크
    static boolean checkRipe(int n, int m){

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tomatoMap[i][j] == 0) return false;
            }
        }
        return true;
    }
}
class Node{
    int x,y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
