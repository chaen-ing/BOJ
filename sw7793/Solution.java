package sw7793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	static int R, C;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static ArrayDeque<Node> devil;
	static ArrayDeque<Node> moving;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			devil = new ArrayDeque<>();
			moving = new ArrayDeque<>();
			visited = new boolean[R][C];
			map = new char[R][C];

			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				for (int j = 0; j < C; j++) {
					char c = line.charAt(j);
					map[i][j] = c;
					if (c == '*')
						devil.add(new Node(i, j, 0));
					else if (moving.isEmpty() && c == 'S') {
						moving.add(new Node(i, j, 0));
						map[i][j] = '.';
					}
				}
			}    // 초기화 종료

			sb.append("#").append(tc).append(" ");
			int res = bfs();
			if (res == -1)
				sb.append("GAME OVER\n");
			else
				sb.append(res).append("\n");
		}

		System.out.println(sb);
	}

	static int bfs() {
		while (!moving.isEmpty()) {
			// 악마 확산
			int size = devil.size();
			for (int i = 0; i < size; i++) {
				Node curr = devil.poll();

				for (int j = 0; j < 4; j++) {
					int nr = curr.r + dr[j];
					int nc = curr.c + dc[j];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] != '.')
						continue;

					map[nr][nc] = '*';
					devil.offer(new Node(nr, nc, 0));
				}
			}

			// 사람 먼저 이동
			size = moving.size();
			for (int i = 0; i < size; i++) {
				Node curr = moving.poll();

				for (int j = 0; j < 4; j++) {
					int nr = curr.r + dr[j];
					int nc = curr.c + dc[j];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc] || map[nr][nc] == '*'
						|| map[nr][nc] == 'X')
						continue;
					if (map[nr][nc] == 'D')
						return curr.cnt + 1;

					moving.offer(new Node(nr, nc, curr.cnt + 1));
					visited[nr][nc] = true;
				}
			}
		}

		return -1;
	}
}

class Node {
	int r, c, cnt;

	public Node(int r, int c, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}