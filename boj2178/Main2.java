package boj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static boolean [][] visited;
	static int [][] maze;
	static int [][] count;

	static int [] moveX = {0, 0, 1, -1};
	static int [] moveY = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 초기화
		visited = new boolean [N][M];
		maze = new int [N][M];
		count = new int [N][M];
		for(int i = 0; i < N; i++){
			String [] split = br.readLine().split("");
			for(int j = 0; j < M; j++){
				maze[i][j] = Integer.parseInt(split[j]);
			}
		}

		bfs(N,M);

		System.out.println(count[N-1][M-1]);

	}

	public static void bfs(int N, int M){
		Queue<Noode> queue = new LinkedList<>();
		queue.offer(new Noode(0,0));
		count[0][0] = 1;
		visited[0][0] = true;

		while(!queue.isEmpty()){
			Noode top = queue.poll();
			int cnt = count[top.x][top.y];

			for(int i = 0; i < 4; i++){
				int x = top.x + moveX[i];
				int y = top.y + moveY[i];

				if(x < 0 || y < 0 || x >= N || y >= M)	continue;
				// 이동가능한 칸이면서 방문한적 없을때
				if(maze[x][y] == 1 && !visited[x][y]){
					queue.offer(new Noode(x,y));
					count[x][y] = cnt + 1;
					visited[x][y] = true;
				}
			}
		}
	}
}

class Noode{
	int x;
	int y;

	Noode(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
