package boj1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, start, end;
	static ArrayList<Edge>[] adjList;
	static boolean[] visited;
	static int[] minDist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());    // 도시
		M = Integer.parseInt(br.readLine());    // 버스

		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int wgt = Integer.parseInt(st.nextToken());
			adjList[start].add(new Edge(end, wgt));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dijkstra();
		System.out.println(minDist[end]);
	}

	static void dijkstra() {
		visited = new boolean[N + 1];
		minDist = new int[N + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);

		minDist[start] = 0;
		// start를 visited 처리안함 -> minDist에 값들 채우기 위해

		for (int i = 1; i <= N; i++) {
			// 출발지에서 가장 가까운 미탐색 정점 찾기
			int cur = -1, min = Integer.MAX_VALUE;
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > minDist[j]) {
					cur = j;
					min = minDist[j];
				}
			}

			if (cur == -1)
				break;    // 없으면 종료

			visited[cur] = true;
			// 연결된 최소비용 갱신 : 방문한적 없고, 현재 갖고 있는 값이 더 크면
			for (Edge edge : adjList[cur]) {
				if (!visited[edge.vertex] && minDist[edge.vertex] > min + edge.wgt) {
					minDist[edge.vertex] = min + edge.wgt;
				}
			}
		}
	}
}

class Edge {
	int vertex;
	int wgt;

	public Edge(int vertex, int wgt) {
		this.vertex = vertex;
		this.wgt = wgt;
	}
}
