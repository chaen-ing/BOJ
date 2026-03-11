package sw1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;          // 고객 수
	static int[] x, y;     // 0: 회사, 1: 집, 2~: 고객
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());   // 고객 수

			x = new int[N + 2];
			y = new int[N + 2];
			visited = new boolean[N + 2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}

			answer = Integer.MAX_VALUE;

			// 시작: 회사(0번)에서 출발
			dfs(0, 0, 0);

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	// current: 현재 위치 인덱스
	// count: 방문한 고객 수
	// sum: 현재까지 이동 거리
	static void dfs(int current, int count, int sum) {
		// 가지치기
		if (sum >= answer) return;

		// 모든 고객 방문 완료
		if (count == N) {
			sum += distance(current, 1);   // 현재 위치 -> 집
			answer = Math.min(answer, sum);
			return;
		}

		// 고객은 2번부터 N+1번까지
		for (int i = 2; i < N + 2; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, count + 1, sum + distance(current, i));
				visited[i] = false;
			}
		}
	}

	static int distance(int a, int b) {
		return Math.abs(x[a] - x[b]) + Math.abs(y[a] - y[b]);
	}
}