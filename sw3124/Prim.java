package sw3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());    // 정점
			int E = Integer.parseInt(st.nextToken());    // 간선

			Node[] adjList = new Node[V + 1];
			boolean[] visited = new boolean[V + 1];

			// 인접리스트 생성
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				adjList[from] = new Node(to, weight, adjList[from]);
				adjList[to] = new Node(from, weight, adjList[to]);
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(1, 0, null));

			long result = 0; // 주의
			int cnt = 0;

			while (!pq.isEmpty()) {
				Node minNode = pq.poll();
				int minVertex = minNode.vertex;
				int minWeight = minNode.weight;

				if (visited[minVertex])
					continue;

				visited[minVertex] = true;
				result += minWeight;
				cnt++;

				if (cnt == V)
					break;

				for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
					if (!visited[temp.vertex]) {
						pq.offer(new Node(temp.vertex, temp.weight, null));
					}
				}

			}

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

}

class Node implements Comparable<Node> {
	int vertex;
	int weight;
	Node next;

	public Node(int vertex, int weight, Node next) {
		this.vertex = vertex;
		this.weight = weight;
		this.next = next;
	}

	@Override
	public int compareTo(Node node) {
		return Integer.compare(this.weight, node.weight);
	}
}
