package sw1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

	static int N;
	static double E;
	static int[] x;
	static int[] y;
	static Node[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());    // 섬 개수

			x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			y = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			E = Double.parseDouble(br.readLine());

			adjList = new Node[N];
			visited = new boolean[N];

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					long weight = (long)(Math.pow((x[i] - x[j]), 2) + Math.pow((y[i] - y[j]), 2));

					adjList[i] = new Node(j, weight, adjList[i]);
					adjList[j] = new Node(i, weight, adjList[j]);
				}
			}

			double sum = 0;
			int cnt = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0, null));

			while (!pq.isEmpty()) {
				Node tmp = pq.poll();
				int tmpVertex = tmp.vertex;
				double tmpWeight = tmp.weight;

				if (visited[tmpVertex])
					continue;

				visited[tmpVertex] = true;
				cnt++;
				sum += (tmpWeight * E);

				if (cnt == N)
					break;

				for (Node temp = adjList[tmpVertex]; temp != null; temp = temp.next) {
					if (!visited[temp.vertex]) {
						pq.offer(new Node(temp.vertex, temp.weight, null));
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(Math.round(sum)).append("\n");
		}

		System.out.println(sb);
	}

}

class Node implements Comparable<Node> {
	int vertex;
	double weight;
	Node next;

	public Node(int vertex, double weight, Node node) {
		this.vertex = vertex;
		this.weight = weight;
		this.next = node;
	}

	@Override
	public int compareTo(Node o) {
		return Double.compare(this.weight, o.weight);
	}
}

