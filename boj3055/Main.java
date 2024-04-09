package boj3055;

import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[][] check;
    static int[] DX = {1,-1,0,0};
    static int[] DY = {0,0,1,-1};
    static Queue<Node> water;
    static Node endNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        check = new int[R][C];

        Node startNode = new Node(0,0); // 고슴도치 위치
        water = new LinkedList<>();

        // map 입력받기
        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = line.charAt(j);
                if (line.charAt(j)== 'S'){  // 시작
                    startNode = new Node(i,j);
                }else if(line.charAt(j) == '*'){    // 물
                    check[i][j] = -1;
                    water.offer(new Node(i,j));
                }else if(line.charAt(j) == 'X'){    // 돌
                    check[i][j] = -1;
                }else if(line.charAt(j) == 'D'){    // 종료
                    endNode = new Node(i,j);
                }
            }
        }

        boolean flag = bfs(R,C,startNode);
        if(!flag)   System.out.println("KAKTUS");
        else System.out.println(check[endNode.x][endNode.y]);
    }

     static boolean bfs(int r, int c, Node startNode){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startNode);

        int time = 0;

        while(!queue.isEmpty()) {
            time++;
            flood(r,c);    // 물 흐름

            int size = queue.size();
            while(size-->0) {    // 현재 큐에 있는 횟수만큼 반복
                Node node = queue.poll();
                int minTime = check[node.x][node.y];

                for (int i = 0; i < 4; i++) {
                    int dx = node.x + DX[i];
                    int dy = node.y + DY[i];

                    if (dx < 0 || dx >= r || dy < 0 || dy >= c) { // 범위
                        continue;
                    } else if (check[dx][dy] == 0) {
                        check[dx][dy] = time;
                        queue.offer(new Node(dx, dy));
                    }

                    if (dx == endNode.x && dy == endNode.y) // 종료노드 도달시 끝
                        return true;


                }
            }


        }
        return false;   // 종료노드에 도달 불가
    }

    static void flood(int r, int c) {
        int size = water.size();

        for (int i = 0; i < size; i++) {
            Node node = water.poll();

            for (int j = 0; j < 4; j++) {
                int dx = node.x + DX[j];
                int dy = node.y + DY[j];

                if (dx < 0 || dx >= r || dy < 0 || dy >= c) { // 범위 초과
                    continue;
                } else if (check[dx][dy] == -1) {   // 이미 방문 or 돌
                    continue;
                } else if (dx == endNode.x && dy == endNode.y) {
                    continue;
                } else {
                    check[dx][dy] = -1;
                    water.offer(new Node(dx, dy));
                }
            }
        }
    }
}
    class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

