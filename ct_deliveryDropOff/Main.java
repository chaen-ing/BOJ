package ct_deliveryDropOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 삼성 25 하반기 오전 1번 택배하차
 * N * N (N <= 50)
 * 택배 M개 (택배번호는 1 ~ 100)
 * 1. 택배 투입 : k번, h세로, w가로, c열
 * 2. 좌측 하차 : 여러개 가능하면 작은 숫자
 * 3. 우측 하차
 * - 항상 아래로 중력 작용
 * - 중력은 맨 아래 + 1 칸부터
 */
public class Main {
	static int N, M;
	static int[][] map;
	static Package[] packages;

	// dropOff
	static boolean[] visited;
	static boolean[] canDropOff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		packages = new Package[101];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()) - 1;

			packages[k] = new Package(h, w);
			initPackage(k, h, w, c);
		}

		int cnt = 0;
		while (true) {
			dropOffLeft();
			gravity();
			cnt++;
			if (cnt == M)
				break;

			dropOffRight();
			gravity();
			cnt++;
			if (cnt == M)
				break;
		}

	}

	/**
	 * 택배 투입
	 * 1. 투입되는 택배가 있어야하는 열 구하기
	 * 2. 해당 열의 가장 큰 행 구해서 넣기
	 * ex. 2,3,4라면 2가 0인 가장 큰곳, 3이 0인 가장 큰곳 이런식으로 구해서 최소값 자리로
	 */
	static void initPackage(int k, int h, int w, int c) {
		int maxRow = N;

		for (int i = c; i < c + w; i++) {
			int colMaxRow = N - 1;
			for (int j = 0; j < N; j++) {
				if (map[j][i] == 0)
					colMaxRow = j;
				else
					break;
			}
			maxRow = Math.min(maxRow, colMaxRow);
		}

		for (int i = maxRow; i > maxRow - h; i--) {
			for (int j = c; j < c + w; j++) {
				map[i][j] = k;
			}
		}
	}

	/**
	 * 택배 빼기
	 *  - 0열 0행부터 오른쪽 이동 발견하면 멈추기
	 * 	- 아래로 없으면 O
	 * 	- 아래로 존재 -> 아래로 내려간 후 좌측 탐색 반복 : 안막혔으면 O, 막혔으면 pass
	 * 	- 다 넣어놓고 작은 숫자
	 */
	static void dropOffLeft() {
		visited = new boolean[101];
		canDropOff = new boolean[101];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 좌측에서부터 보고 가장 먼저 만난 숫자
				if (map[i][j] != 0) {
					if (visited[map[i][j]])
						break;

					int num = map[i][j];
					visited[num] = true;

					boolean possible = true;
					// 밑에 숫자가 이어지면 좌측으로 쭉 보고 반복
					for (int nr = i + 1; nr < N; nr++) {
						// 뭉탱이 끝
						if (map[nr][j] != num)
							break;

						for (int nc = j - 1; nc >= 0; nc--) {
							if (map[nr][nc] != 0) {
								possible = false;
								break;
							}
						}

						if (!possible)
							break;
					}

					if (possible)
						canDropOff[num] = true;
					break;
				}
			}
		}

		// 제거
		for (int i = 0; i < 101; i++) {
			if (canDropOff[i]) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if (map[j][k] == i)
							map[j][k] = 0;
					}
				}
				System.out.println(i);
				break;
			}
		}
	}

	static void dropOffRight() {
		visited = new boolean[101];
		canDropOff = new boolean[101];

		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				// 우측에서부터 보고 가장 먼저 만난 숫자
				if (map[i][j] != 0) {
					if (visited[map[i][j]])
						break;

					int num = map[i][j];
					visited[num] = true;

					boolean possible = true;
					// 밑에 숫자가 이어지면 우측으로 쭉 보고 반복
					for (int nr = i + 1; nr < N; nr++) {
						// 뭉탱이 끝
						if (map[nr][j] != num)
							break;

						for (int nc = j + 1; nc < N; nc++) {
							if (map[nr][nc] != 0) {
								possible = false;
								break;
							}
						}
						if (!possible)
							break;
					}

					if (possible)
						canDropOff[num] = true;
					break;
				}
			}
		}

		// 제거
		for (int i = 0; i < 101; i++) {
			if (canDropOff[i]) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if (map[j][k] == i)
							map[j][k] = 0;
					}
				}
				System.out.println(i);
				break;
			}
		}
	}

	/**
	 * 중력 적용
	 * - 아래서부터 보기
	 * - 숫자발견하면 아래로 어디까지 내릴 수 있는지 판단 후 내림
	 * - visited
	 */
	static void gravity() {
		visited = new boolean[101];

		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {

				if (map[i][j] != 0) {
					if (visited[map[i][j]])
						continue;

					int num = map[i][j];
					visited[num] = true;

					// 내릴 수 있는 최대 찾기
					int maxRow = N - 1;
					for (int k = j; k < j + packages[num].w; k++) {
						int colMaxRow = i;

						for (int l = i + 1; l < N; l++) {
							if (map[l][k] == 0)
								colMaxRow = l;
							else {
								colMaxRow = l - 1;
								break;
							}
						}

						maxRow = Math.min(maxRow, colMaxRow);
					}

					//System.out.println(maxRow);

					if (maxRow == i)
						continue;

					// 없애고 내리기
					for (int k = 0; k < N; k++) {
						for (int l = 0; l < N; l++) {
							if (map[k][l] == num)
								map[k][l] = 0;
						}
					}

					for (int k = maxRow; k > maxRow - packages[num].h; k--) {
						for (int l = j; l < j + packages[num].w; l++) {
							map[k][l] = num;
						}
					}

				}
			}
		}
	}

	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Package {
	int h;
	int w;

	public Package(int h, int w) {
		this.h = h;
		this.w = w;
	}
}