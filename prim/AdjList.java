package prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AdjList {
	class Node {
		int vertex;
		int weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	public void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		Node[] adjList = new Node[V];    // 인접 리스트
		boolean[] visited = new boolean[V]; // 트리 정점 체크
		int[] minEdge = new int[V]; // 트리 정점들과 자신과의 간선 비용 최소 값

		// 인접리스트
		StringTokenizer st = null;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}

		// 전처리 1 : minEdges는 최소값 유지이므로 큰값으로 초기화
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		// 전처리 2 : 임의의 시작정점 minEdge 0으로
		minEdge[0] = 0;

		int result = 0; // MST 비용
		int c;
		for (c = 0; c < V; c++) {
			// step 1 : 비트리 정 중 최소간선비용 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;

			for (int i = 0; i < V; i++) {
				if (!visited[i] && min > minEdge[i]) {
					minVertex = i;
					min = minEdge[i];
				}
			}

			if (minVertex == -1)
				break;
			visited[minVertex] = true;
			result += min;

			// step 2 : 트리에 새로 추가된 정점과 비트리 인접정점의 간선비용 비교해서 업뎃
			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
				}
			}

		}

		System.out.println(c == V ? result : -1);

	}
}
