package boj2667;
import java.io.*;
import java.util.*;

public class Main {
    static int [][] house;
    static boolean [][] visited;
    static int [] DX = {1,-1,0,0};
    static int [] DY = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        house = new int[N][N];
        visited = new boolean[N][N];

        // 단지 입력
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                house[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(house[i][j] == 1 && !visited[i][j]){  // 집 존재하고 방문한적 X
                    Queue<Node> queue = new LinkedList<>();
                    queue.offer(new Node(i,j));
                    visited[i][j] = true;
                    int cnt = 1;

                    while(!queue.isEmpty()){
                        Node node = queue.poll();

                        for(int k = 0; k < 4; k++){ // 모든 방향 체크
                            int dx = node.x + DX[k];
                            int dy = node.y + DY[k];

                            if(dx < 0 || dx >= N || dy < 0 || dy >= N)
                                continue;
                            else if(!visited[dx][dy] && house[dx][dy] == 1){
                                queue.offer(new Node(dx,dy));
                                visited[dx][dy] = true;
                                cnt++;
                            }
                        }
                    }
                    arrayList.add(cnt);
                }
            }
        }

        Collections.sort(arrayList);

        System.out.println(arrayList.size());
        for(int i : arrayList){
            System.out.println(i);
        }




    }
}

class Node{
    int x, y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
