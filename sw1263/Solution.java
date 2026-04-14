package sw1263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW1263_HumanNetwork2
public class Solution {
	static int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (i == j)
						dist[i][j] = 0;
					else
						dist[i][j] = (num == 0 ? INF : num);
				}
			}

			floydWarshall();

			int minSum = INF;
			for (int i = 0; i < N; i++) {
				int tmp = 0;
				for (int j = 0; j < N; j++) {
					tmp += dist[i][j];
				}
				minSum = Math.min(minSum, tmp);
			}

			sb.append("#").append(tc).append(" ").append(minSum).append("\n");
		}

		System.out.println(sb);

	}

	static void floydWarshall() {
		for (int i = 0; i < N; i++) {    // 경유
			for (int j = 0; j < N; j++) {    // 출발
				if (i == j)
					continue;
				for (int k = 0; k < N; k++) {    // 도착
					if (k == i || k == j)
						continue;
					if (dist[j][i] == INF || dist[i][k] == INF)
						continue;
					dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
				}
			}
		}
	}
}
