package sw2382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K;
	static Node[][] microbe;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			microbe = new Node[N][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int move = Integer.parseInt(st.nextToken());

				microbe[r][c] = new Node(cnt, move, cnt);
			}

			while (M-- > 0) {
				Node[][] next = new Node[N][N];

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (microbe[i][j] == null)
							continue;

						Node curr = microbe[i][j];
						int nr = i + dr[curr.move];
						int nc = j + dc[curr.move];
						int nCnt = curr.cnt;
						int nMove = curr.move;

						// 약품
						if (nr == 0 || nc == 0 || nr == N - 1 || nc == N - 1) {
							nCnt /= 2;
							if (nCnt == 0)
								continue;
							nMove = changeMove(nMove);
						}

						if (next[nr][nc] == null) {    // 빈 곳에는 바로 넣음
							next[nr][nc] = new Node(nCnt, nMove, nCnt);
						} else {    // 미생물 발견
							next[nr][nc].cnt += nCnt;

							if (next[nr][nc].maxCnt < nCnt) {
								next[nr][nc].maxCnt = nCnt;
								next[nr][nc].move = nMove;
							}
						}
					}
				}

				microbe = next;
			}

			long sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (microbe[i][j] != null) {
						sum += microbe[i][j].cnt;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}

		System.out.print(sb);
	}

	static int changeMove(int move) {
		switch (move) {
			case 1:
				return 2;
			case 2:
				return 1;
			case 3:
				return 4;
			case 4:
				return 3;
			default:
				return -1;
		}
	}
}

class Node {
	int cnt;
	int move;
	int maxCnt;   // 최대 미생물 수

	public Node(int cnt, int move, int maxCnt) {
		this.cnt = cnt;
		this.move = move;
		this.maxCnt = maxCnt;
	}
}