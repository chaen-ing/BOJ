package sw5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SW5643_HeightOrder
public class Solution {
	static int INF = Integer.MAX_VALUE;
	static int N, M;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			// 초기화
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				dist[a][b] = 1;
			}

			floydWarshall();

			int sum = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					// a -> b, b -> a 모두 도달 불가능하면 false
					if (dist[i][j] == INF && dist[j][i] == INF) {
						flag = false;
						break;
					}
				}
				if (flag)
					sum++;
			}

			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}

		System.out.println(sb);
	}

	static void floydWarshall() {
		for (int i = 0; i < N; i++) {    // 경
			for (int j = 0; j < N; j++) {    // 출
				if (i == j)
					continue;
				for (int k = 0; k < N; k++) {    // 도
					if (k == j || k == i)
						continue;
					if (dist[j][i] == INF || dist[i][k] == INF)
						continue;
					dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
				}
			}
		}
	}
}
