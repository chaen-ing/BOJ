package boj1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		if (M == 1) {
			System.out.println("YES");
			return;
		}

		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (st.nextToken().equals("1"))
					list[i].add(j);
			}
		}

		int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int start = 0;
		while (start < M - 1) {
			if (!bfs(order[start], order[start + 1])) {
				System.out.println("NO");
				return;
			}
			start++;
		}

		System.out.println("YES");
	}

	static boolean bfs(int start, int end) {
		if (start == end)
			return true;

		boolean[] visit = new boolean[N + 1];
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visit[start] = true;

		while (!queue.isEmpty()) {
			int top = queue.poll();
			for (int i = 0; i < list[top].size(); i++) {
				int tmp = list[top].get(i);
				if (tmp == end)
					return true;
				if (visit[tmp])
					continue;
				queue.offer(tmp);
				visit[tmp] = true;
			}
		}

		return false;
	}
}
