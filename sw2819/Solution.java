package sw2819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	static int[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static HashSet<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			board = new int[4][4];
			for (int i = 0; i < 4; i++) {
				board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(0, i, j, board[i][j]);
				}
			}

			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int cnt, int r, int c, int num) {
		if (cnt == 6) {
			set.add(num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr > 3 || nc > 3)
				continue;

			dfs(cnt + 1, nr, nc, num * 10 + board[nr][nc]);
		}
	}
}
