package sw3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int[] parents;
	static Edge[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			edges = new Edge[E];
			parents = new int[V + 1];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			}

			Arrays.sort(edges);

			makeSet();

			long sum = 0L;
			int cnt = 0;

			for (int i = 0; i < E; i++) {
				if (union(edges[i].a, edges[i].b)) {    // 사이클 안생기면
					sum += edges[i].weight;
					if (++cnt == V - 1)
						break;
				}

			}

			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}

		System.out.println(sb);
	}

	static void makeSet() {
		for (int i = 1; i <= V; i++) {
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
	int weight;

	public Edge(int a, int b, int weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}
