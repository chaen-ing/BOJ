package sw1868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static char[][] map;
	static int N;
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	static boolean[][] visited;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			visited = new boolean[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j])
						continue;
					if (map[i][j] == '*')
						continue;
					if (checkZero(i, j)) {    // 0인곳은 주변 체크
						click(i, j);
						ans++;

					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.' && !visited[i][j])
						ans++;
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}

	static void click(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			visited[cur[0]][cur[1]] = true;

			for (int i = 0; i < 8; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				if (!checkZero(nr, nc))
					continue;
				queue.offer(new int[] {nr, nc});

			}
		}

	}

	// 0 만들 수 있는지 체크
	static boolean checkZero(int r, int c) {
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (map[nr][nc] == '*')
				return false;    // 0 못만들면 리턴
		}
		return true;
	}
}
