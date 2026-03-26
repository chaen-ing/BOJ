package boj1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parents = new int[V + 1];
		makeSet();

		// 최소 간선 찾기 위해 pq
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())));
		}

		long sum = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			if (cnt == V - 1)
				break;

			Node tmp = pq.poll();

			// 사이클 생기는지 확인
			if (findSet(tmp.start) == findSet(tmp.end))
				continue;

			union(tmp.start, tmp.end);
			sum += tmp.wgt;
			cnt++;
		}

		System.out.println(sum);
	}

	static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}

	static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);

		parents[rootB] = rootA;
	}

	static int findSet(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = findSet(parents[x]);
	}
}

class Node implements Comparable<Node> {
	int start;
	int end;
	int wgt;

	public Node(int start, int end, int wgt) {
		this.start = start;
		this.end = end;
		this.wgt = wgt;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.wgt, o.wgt);
	}
}