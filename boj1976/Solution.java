package boj1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		if (M == 1) {
			System.out.println("YES");
			return;
		}

		// makeSet
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (st.nextToken().equals("0"))
					continue;
				union(i, j);
			}
		}

		st = new StringTokenizer(br.readLine());
		int prev = Integer.parseInt(st.nextToken());
		int next;
		while (st.hasMoreTokens()) {
			next = Integer.parseInt(st.nextToken());
			if (findSet(prev) != findSet(next)) {
				System.out.println("NO");
				return;
			}
			prev = next;
		}

		System.out.println("YES");
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);

		if (rootA == rootB)
			return;
		parents[rootB] = rootA;
	}

}
