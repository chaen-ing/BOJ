package sw3289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			sb.append("#").append(tc).append(" ");

			makeSet();
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 0) {    // 합치기
					union(a, b);
				} else {    // 서로소 여부 판단
					sb.append((find(a) == find(b) ? 1 : 0));
				}
			}
			sb.append("\n");

		}

		System.out.println(sb);
	}

	static void makeSet() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);    // 경로압축
	}

	static void union(int a, int b) {
		int findA = find(a);
		int findB = find(b);

		if (findA == findB)
			return;
		parent[findB] = findA;
	}
}
