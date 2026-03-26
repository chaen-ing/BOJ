package boj1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static PriorityQueue<Edge> pq;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())));
		}

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		int cnt = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			if (cnt == N - 1)
				break;
			Edge tmp = pq.poll();

			if (findSet(tmp.start) == findSet(tmp.end))
				continue;
			union(tmp.start, tmp.end);
			sum += tmp.wgt;
			cnt++;
		}

		System.out.println(sum);

	}

	static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);

		if (rootA == rootB)
			return;
		parents[rootB] = rootA;
	}

	static int findSet(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = findSet(parents[x]);
	}

}

class Edge implements Comparable<Edge> {
	int start;
	int end;
	int wgt;

	public Edge(int start, int end, int wgt) {
		this.start = start;
		this.end = end;
		this.wgt = wgt;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.wgt, o.wgt);
	}
}
