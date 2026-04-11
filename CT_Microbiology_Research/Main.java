package CT_Microbiology_Research;

import java.util.*;
import java.io.*;

/**
 * 삼성 25 상반기 오후 1번 : 미생물 연구
 * 2 <= N * N <= 15
 * 총 Q번 실험 <= 50
 * 1. 미생물 투입
 * 2. 배양 용기 이동
 * 3. 실험 결과 기록
 * - 옮겨지는게 항상 직사각형이 아님 -> 개수를 저장?
 */

public class Main {
	static int N, Q;
	static int[][] map;
	static int[][] newMap;

	// putMicrobe
	static ArrayDeque<Edge> queue;
	static boolean[] visitedMicrobe;
	static boolean[] invalid;
	static boolean[][] visitedMap;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	// move
	static ArrayList<Area> microbeList;
	static ArrayList<Edge> abs;
	static ArrayList<Edge> edges;

	// size
	static int[] microbeSize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = N - Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = N - Integer.parseInt(st.nextToken());

			putMicrobe(d, a, b, c, i);

			moveMap();

			System.out.println(calc());
		}
	}

	/**
	 * 1. 미생물 투입
	 * - 투입
	 * - 영역 체크 -> bfs
	 * - 지우기
	 */
	static void putMicrobe(int r1, int c1, int r2, int c2, int num) {
		// 투입
		for (int i = r1; i < r2; i++) {
			for (int j = c1; j < c2; j++) {
				map[i][j] = num;
			}
		}

		visitedMicrobe = new boolean[Q + 1];
		visitedMap = new boolean[N][N];
		invalid = new boolean[Q + 1];

		// 나눠지는거 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 || visitedMap[i][j] || invalid[map[i][j]])
					continue;

				// 나온적 있는 미생물인데 영역은 방문 x -> 나눠짐
				if (visitedMicrobe[map[i][j]]) {
					invalid[map[i][j]] = true;
				} else {
					bfs(i, j);
				}
			}
		}

		// 지우기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;
				if (invalid[map[i][j]])
					map[i][j] = 0;
			}
		}
	}

	static void bfs(int r, int c) {
		queue = new ArrayDeque<>();
		queue.offer(new Edge(r, c));

		int num = map[r][c];
		visitedMicrobe[num] = true;

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			visitedMap[edge.r][edge.c] = true;

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + edge.r;
				int nc = dc[i] + edge.c;

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != num || visitedMap[nr][nc])
					continue;

				queue.offer(new Edge(nr, nc));
				visitedMap[nr][nc] = true;
			}
		}
	}

	/**
	 * 2. 배양 용기 이동
	 * - 모든 미생물을 새로운 배양 용기로 이동
	 * - 기존 용기의 무리 중 가장 영역이 넓은거 선택 -> 둘 이상이면 가장 먼저 투입된거
	 * - 옮길때는 형태 그대로, 겹치지 않도록 하되 x좌표 작은곳 > y좌표 작은곳 순서로
	 * 	 즉, 0,0부터 채운다
	 * - 둘 수 없는 무리가 생기면 사라짐
	 * - 1. 영역 정리하면서 정렬
	 */

	static void moveMap() {
		newMap = new int[N][N];
		visitedMap = new boolean[N][N];
		microbeList = new ArrayList<>();

		// 1. 영역 정리
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;
				if (visitedMap[i][j])
					continue;

				microbeList.add(extractArea(i, j));
			}
		}

		Collections.sort(microbeList);

		// 2. 영역 이동
		for (Area area : microbeList) {
			boolean flag = false;

			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (canReplace(area, j, i)) {
						replace(area, j, i);
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}
		}

		// 복사
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = newMap[i][j];
			}
		}
	}

	// 이동가능한지 확인
	static boolean canReplace(Area area, int r, int c) {
		for (Edge e : area.edges) {
			int nr = r - e.r;
			int nc = c + e.c;

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				return false;
			if (newMap[nr][nc] != 0)
				return false;
		}
		return true;
	}

	// 이동
	static void replace(Area area, int r, int c) {
		for (Edge e : area.edges) {
			newMap[r - e.r][c + e.c] = area.num;
		}
	}

	static Area extractArea(int r, int c) {
		queue = new ArrayDeque<>();
		queue.offer(new Edge(r, c));

		int num = map[r][c];
		visitedMap[r][c] = true;

		abs = new ArrayList<>();

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			abs.add(new Edge(edge.r, edge.c));

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + edge.r;
				int nc = dc[i] + edge.c;

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != num || visitedMap[nr][nc])
					continue;

				queue.offer(new Edge(nr, nc));
				visitedMap[nr][nc] = true;
			}
		}

		// 영역 좌표로 추출 후 기준점 기준으로 다시 상대좌표 설정
		int baseR = -1;
		int baseC = Integer.MAX_VALUE;

		for (Edge e : abs) {
			baseR = Math.max(baseR, e.r);   // 가장 아래
			baseC = Math.min(baseC, e.c);   // 가장 왼쪽
		}

		edges = new ArrayList<>();
		for (Edge e : abs) {
			edges.add(new Edge(baseR - e.r, e.c - baseC));
		}

		return new Area(num, edges);
	}

	/**
	 * 3. 실험 결과 기록
	 * - 무리 중 상하좌우로 맞닿은 면이 있는 무리끼리는 인접한 무리
	 * - 모든 인접한 무리 쌍 확인 (A, B가 여러면 닿아있더라도 한번임)
	 * - 성과 : 모든 쌍의 (A 넓이 * B 넓이) 합
	 */
	static int calc() {
		boolean[][] visitedMap = new boolean[Q + 1][Q + 1];
		microbeSize = new int[Q + 1];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = map[i][j];
				if (num == 0)
					continue;
				microbeSize[num]++;

				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					if (map[nr][nc] == 0)
						continue;
					if (map[nr][nc] != num) {
						int max = Math.max(num, map[nr][nc]);
						int min = Math.min(num, map[nr][nc]);
						visitedMap[max][min] = true;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 0; i <= Q; i++) {
			for (int j = 0; j <= Q; j++) {
				if (visitedMap[i][j]) {
					ans += microbeSize[i] * microbeSize[j];
				}
			}
		}

		return ans;
	}

	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Area implements Comparable<Area> {
	int num;
	ArrayList<Edge> edges;

	public Area(int num, ArrayList<Edge> edges) {
		this.num = num;
		this.edges = edges;
	}

	@Override
	public int compareTo(Area o) {
		if (this.edges.size() != o.edges.size()) {
			return o.edges.size() - this.edges.size(); // 큰 순
		}
		return this.num - o.num; // 번호 작은 순
	}

}

class Edge {
	int r;
	int c;

	public Edge(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
