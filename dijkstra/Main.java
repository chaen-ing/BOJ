package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V, E; // 정점, 간선
	static Node[] adjList;    //인접리스트
	static boolean[] visited;
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
		visited = new boolean[V];
		minDist = new int[V];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}    // 인접리스트 완성

		final int INF = Integer.MAX_VALUE;
		Arrays.fill(minDist, INF);
		minDist[start] = 0;    //출발 비용 0

		for (int i = 0; i < V; i++) {
			// step 1 : 출발지에서 가까운 정점으로 미탐색 정점 중 가장 가까운거 찾기
			int cur = -1, min = INF;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > minDist[j]) {
					cur = j;
					min = minDist[j];
				}
			}

			if (cur == -1)
				break; // 근처 정점 없으면 종료
			visited[cur] = true;

			// step 2 : 최소비용 갱신
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minDist[temp.vertex] > min + temp.weight) {
					minDist[temp.vertex] = min + temp.weight;
				}
			}

		}

		System.out.println(minDist[end] != INF ? minDist[end] : -1);

	}
}

class Node {
	int vertex;
	int weight;
	Node next;

	public Node(int vertex, int weight, Node node) {
		this.vertex = vertex;
		this.weight = weight;
		this.next = node;
	}
}
