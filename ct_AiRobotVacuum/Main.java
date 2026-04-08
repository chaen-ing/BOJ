package ct_AiRobotVacuum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N, K, L;
	static int[][] dust;
	static boolean[][] block;
	static boolean[][] vacuumPos;
	static Vacuum[] vacuums;

	// moveVacuum
	static boolean[][] visited;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		/**
		 * 초기화
		 */
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());    // 청소기
		L = Integer.parseInt(st.nextToken());    // 반복
		dust = new int[N][N];
		block = new boolean[N][N];
		vacuumPos = new boolean[N][N];
		vacuums = new Vacuum[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == -1) {
					block[i][j] = true;
				} else if (n != 0) {
					dust[i][j] = n;
				}
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			vacuums[i] = new Vacuum(r, c);
			vacuumPos[r][c] = true;
		}

		// L번 반복
		for (int t = 0; t < L; t++) {
			moveVacuum();
			clean();
			sb.append(updateDust()).append("\n");
		}

		System.out.println(sb);
	}

	/**
	 * 청소기 이동 (bfs)
	 * 상,좌,우,하 순서로 이동하면서 발견하면 확정
	 * 같은게 여러개면 가장 작은 행, 열로 채택
	 */
	public static void moveVacuum() {
		for (int i = 0; i < K; i++) {    // 청소기 순서대로
			if (dust[vacuums[i].r][vacuums[i].c] != 0)    // 청소기자리에 먼지 확산가능하므로
				continue;

			ArrayDeque<Vacuum> moving = new ArrayDeque<>();
			visited = new boolean[N][N];
			moving.offer(vacuums[i]);
			visited[vacuums[i].r][vacuums[i].c] = true;
			vacuumPos[vacuums[i].r][vacuums[i].c] = false;
			int resR = N, resC = N;

			while (!moving.isEmpty()) {
				int size = moving.size();    // 이동횟수 같은거끼리는 다봐야함

				for (int j = 0; j < size; j++) {
					Vacuum vacuum = moving.poll();

					int nr = -1, nc = -1;
					for (int k = 0; k < 4; k++) {
						nr = vacuum.r + dr[k];
						nc = vacuum.c + dc[k];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;
						if (vacuumPos[nr][nc] || block[nr][nc] || visited[nr][nc])
							continue;

						// 행, 열 작은순서로 채택
						if (dust[nr][nc] != 0) {
							if (resR > nr) {
								resR = nr;
								resC = nc;
							} else if (resR == nr) {
								if (resC > nc)
									resC = nc;
							}
						} else {
							moving.offer(new Vacuum(nr, nc));
							visited[nr][nc] = true;
						}
					}
				}

				if (resR != N && resC != N) {
					vacuums[i] = new Vacuum(resR, resC);
					vacuumPos[resR][resC] = true;
					break;
				}
			}

			if (resR == N && resC == N) {
				vacuumPos[vacuums[i].r][vacuums[i].c] = true;
			}
		}
	}

	/**
	 * 청소
	 * 본인의 주변 먼지량이 가장 큰 방향에서 청소하되
	 * 같으면 좌, 상, 우, 하 순서
	 * 1. 우선순위 선택 : 전체 먼지량이 아닌 "청소할 수 있는 먼지량"
	 * 2. 청소
	 */
	public static void clean() {
		for (int i = 0; i < K; i++) {
			Vacuum vacuum = vacuums[i];
			int dir = 0;
			int minDust = Integer.MAX_VALUE;

			// 우선순위 선택
			for (int j = 0; j < 4; j++) {
				int nr = vacuum.r + dr[j];
				int nc = vacuum.c + dc[j];

				int val = 0;
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !block[nr][nc]) {
					val = Math.min(20, dust[nr][nc]);
				}

				if (val < minDust) {
					dir = j;
					minDust = val;
				}
			}

			// 청소
			dust[vacuum.r][vacuum.c] = Math.max(0, dust[vacuum.r][vacuum.c] - 20);

			for (int j = 0; j < 4; j++) {
				if (j == dir)
					continue;

				int nr = vacuum.r + dr[j];
				int nc = vacuum.c + dc[j];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (dust[nr][nc] == 0 || block[nr][nc])
					continue;

				dust[nr][nc] = Math.max(0, dust[nr][nc] - 20);
			}

		}
	}

	/**
	 * 축적 및 확산
	 * 1. 먼지 축적 : 5씩 추가하면서 미리 더하기
	 * 2. 깨끗한칸만 보면서 확산되는거 합
	 * 	- 이때 확산된거 보면 안됨
	 */
	public static int updateDust() {
		int sum = 0;
		int[][] newDust = new int[N][N];

		// 축적
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dust[i][j] != 0) {
					dust[i][j] += 5;
					sum += dust[i][j];
				}
			}
		}

		// 깨끗한 격자만 보기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (block[i][j] || dust[i][j] != 0)
					continue;

				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					if (block[nr][nc])
						continue;
					cnt += dust[nr][nc];
				}

				newDust[i][j] = cnt / 10;
				sum += newDust[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (newDust[i][j] != 0)
					dust[i][j] = newDust[i][j];
			}
		}

		return sum;

	}

	private static void printMap() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dust[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Vacuum {
	int r, c;

	public Vacuum(int r, int c) {
		this.r = r;
		this.c = c;
	}
}