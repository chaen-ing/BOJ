package sw5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int W, H, N;
	static int map[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new int[H][W];

	}

	// 구슬 떨어뜨리기 : 중복순열
	static boolean drop(int count, int[][] map) {
		int remainCount = getRemain(map);
		if (remainCount == 0) {
			min = 0;
			return true;    // 이 문제에서 나올 있는 가장 최적해
		}

		// 모든 구슬 다 던졌다면 남은 벽돌개수 최소값 갱신
		if (count == N) {
			min = Math.min(min, remainCount);
			return false;
		}

		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) {
			// c열 구슬 낙하시 부서지는 첫 벽돌찾기
			int r = 0;
			while (r < H && map[r][c] == 0)
				++r;
			// 그런 벽돌 없다면 부서지는거 없음. 현재 구슬로 다음 열 시도
			if (r == H)
				continue;

			copy(map, newMap);
			int brick = map[r][c];
			// 연쇄폭발
			boom(newMap, r, c);
			// 벽돌내리기
			if (brick > 1)
				down(newMap);
			// 다음구슬 떨어뜨리기
			if (drop(count + 1, newMap))
				return true;
		}
		return false;
	}

	// 벽돌 연쇄 폭발 ; BFS
	static void boom(int[][] map, int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		// 벽돌깨기
		if (map[r][c] > 1)
			queue.offer(new Point(r, c, map[r][c]));
		map[r][c] = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur.r;
				int nc = cur.c;
				for (int k = 1; k < cur.no - 1; k++) {
					nr += dr[d];
					nc += dc[d];
					if (nr >= 0 && nc >= 0 && nr < H && nc < W && map[nr][nc] != 0) {
						if (map[r][c] > 1)
							queue.offer(new Point(nr, nr, map[nr][nc]));
						map[nr][nc] = 0;
					}
				}
			}
		}
	}

	// 벽돌 내리기
	static void down(int[][] map) {
		// 모든 열에 대해 처리(열 고정 후 처리)
		for (int c = 0; c < W; c++) {
			// 맨아래서부터 올라오며 빈칸 찾기
			int er = H - 1;
			while (er >= 0 && map[er][c] != 0)
				--er;

			if (er < 0)
				continue;
			for (int r = er - 1; r >= 0; r--) {
				if (map[r][c] != 0) {
					map[er][c] = map[r][c];
					map[r][c] = 0;
					--er;
				}
			}
		}
	}

	static void copy(int[][] src, int[][] dest) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}

	static int getRemain(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					++cnt;
			}
		}
		return cnt;
	}

	static class Point {
		int r, c, no;

		public Point(int r, int c, int no) {
			this.r = r;
			this.c = c;
			this.no = no;
		}
	}
}
