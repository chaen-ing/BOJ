package sw1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	static int N;
	static double E;
	static int[] x;
	static int[] y;
	static int[] parents;
	static List<Edge> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());    // 섬 개수

			x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			y = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			E = Double.parseDouble(br.readLine());

			// 섬 간의 거리 구하기 N * (N-1) / 2
			edges = new ArrayList<>();
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					edges.add(new Edge(i, j,
						Math.sqrt(Math.pow((x[i] - x[j]), 2) + Math.pow((y[i] - y[j]), 2))));
				}
			}

			Collections.sort(edges);

			makeSet();

			double sum = 0L;
			int cnt = 0;

			for (Edge edge : edges) {
				if (union(edge.a, edge.b)) {    // 사이클 안생기면
					sum += Math.pow(edge.weight, 2) * E;
					if (++cnt == N - 1)
						break;
				}

			}

			sb.append("#").append(tc).append(" ").append(Math.round(sum)).append("\n");
		}

		System.out.println(sb);
	}

	static void makeSet() {
		parents = new int[N];

		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = findSet(parents[x]);
	}

	static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);

		if (rootA == rootB)
			return false;
		parents[rootB] = rootA;
		return true;
	}
}

class Edge implements Comparable<Edge> {

	int a;
	int b;
	double weight;

	public Edge(int a, int b, double weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.weight, o.weight);
	}

}

