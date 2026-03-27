package boj1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	static ArrayList<Edge>[] graph;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		dist = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Edge(v, w));
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF)
				sb.append("INF").append('\n');
			else
				sb.append(dist[i]).append('\n');
		}
		System.out.print(sb);
	}

	static void dijkstra(int start) {
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		dist[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (cur.weight > dist[cur.to])
				continue;

			for (Edge next : graph[cur.to]) {
				int nextCost = cur.weight + next.weight;

				if (nextCost < dist[next.to]) {
					dist[next.to] = nextCost;
					pq.offer(new Edge(next.to, nextCost));
				}
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

}