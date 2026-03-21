package boj1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		makeSet();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (query == 0)
				union(a, b);    // 합치기
			else {    // 같은 집합인지 판단
				if (findSet(a) == findSet(b))
					sb.append("YES").append("\n");
				else
					sb.append("NO").append("\n");
			}
		}

		System.out.println(sb);

	}

	static void makeSet() {
		arr = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}
	}

	static int findSet(int n) {
		if (n == arr[n])
			return n;
		return findSet(arr[n]);
	}

	static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);

		if (rootA == rootB)
			return;
		arr[rootB] = rootA;
	}
}
