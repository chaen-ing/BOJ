package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstra_pq {
	static int V, E; // 정점, 간선
	static Node[] adjList;    //인접리스트
	// static boolean[] visited; 이거 안써도됨
	static int[] minDist;    // 출발지에서 자신으로의 최소거리

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		adjList = new Node[V];
		minDist = new int[V];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}

		final int INF = Integer.MAX_VALUE;
		Arrays.fill(minDist, INF);
		minDist[start] = 0;    //출발 비용 0
		pq.offer(new Vertex(start, minDist[start]));

		while (!pq.isEmpty()) {
			// step 1 : 출발지에서 가까운 정점으로 미탐색 정점 중 가장 가까운거 찾기
			Vertex cur = pq.poll();
			if (cur.dist > minDist[cur.no])
				continue;    // visited 대체

			// step 2 : 최소비용 갱신
			for (Node temp = adjList[cur.no]; temp != null; temp = temp.next) {
				if (minDist[temp.to] > cur.dist + temp.weight) {
					// visited 안써도 됨 : 인접한것들 중에 이미 방문한 애가 더 비용작을수가 X
					minDist[temp.to] = cur.dist + temp.weight;
					pq.offer(new Vertex(temp.to, minDist[temp.to]));
				}
			}

		}

		System.out.println(minDist[end] != INF ? minDist[end] : -1);

	}

	static class Node {
		int to, weight;
		Node next;

		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int no, dist;

		public Vertex(int no, int dist) {
			super();
			this.no = no;
			this.dist = dist;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
}



