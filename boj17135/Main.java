package boj17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, res;
	static int[][] origin;
	static int[][] map;
	static boolean[] archer;

	// bfs
	static ArrayDeque<Node> attackQ;
	static boolean[][] visited;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}};    // 좌, 상, 우
	static HashSet<Node> attackSet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		origin = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		archer = new boolean[M];
		res = Integer.MIN_VALUE;
		comb(0, 0);
		System.out.println(res);
	}

	static void comb(int cnt, int start) {
		// 궁수 3명 선택시 공격 시뮬레이션
		if (cnt == 3) {
			map = copyMap(origin);
			attack();
			return;
		}
		for (int i = start; i < M; i++) {
			archer[i] = true;
			comb(cnt + 1, i + 1);
			archer[i] = false;
		}
	}

	static void attack() {
		int cnt = 0;
		// bfs로 적 제거가능한지 찾고 > 이동 N번 반복
		for (int i = 0; i < N; i++) {
			attackSet = new HashSet<>();

			for (int j = 0; j < M; j++) {
				if (!archer[j])
					continue;
				bfs(j);
			}

			cnt += attackSet.size();
			for (Node node : attackSet) {
				map[node.r][node.c] = 0;
			}

			move();
		}

		res = Math.max(res, cnt);
	}

	// 가장 가까운 적 찾으면 리턴. 없으면 말고
	static boolean bfs(int c) {
		attackQ = new ArrayDeque<>();
		visited = new boolean[N][M];
		attackQ.offer(new Node(N, c, 0));

		while (!attackQ.isEmpty()) {
			Node cur = attackQ.poll();

			for (int i = 0; i < 3; i++) {
				int nr = cur.r + dir[i][0];
				int nc = cur.c + dir[i][1];
				int nmove = cur.move + 1;

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (visited[nr][nc] || nmove > D)
					continue;

				if (map[nr][nc] == 1) {
					attackSet.add(new Node(nr, nc, 0));
					return true;
				}

				visited[nr][nc] = true;
				attackQ.offer(new Node(nr, nc, nmove));
			}
		}
		return false;
	}

	static void move() {
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < M; j++) {
				map[i][j] = map[i - 1][j];
			}
		}
		for (int j = 0; j < M; j++) {
			map[0][j] = 0;
		}
	}

	static int[][] copyMap(int[][] src) {
		int[][] dst = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(src[i], 0, dst[i], 0, M);
		}
		return dst;
	}
}

class Node {
	int r;
	int c;
	int move;

	public Node(int r, int c, int move) {
		this.r = r;
		this.c = c;
		this.move = move;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Node))
			return false;
		Node node = (Node)o;
		return r == node.r && c == node.c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(r, c);
	}
}
