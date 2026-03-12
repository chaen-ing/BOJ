package sw5658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int N, K;
	static HashSet<String> set;
	static ArrayList<Character> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());    // 크기
			K = Integer.parseInt(st.nextToken());    // K번째로 큰 숫자
			set = new HashSet<>();
			list = new ArrayList<>();

			String line = br.readLine();
			for (int i = 0; i < N; i++) {
				list.add(line.charAt(i));
			}

			// 암호 리스트 만들기
			for (int i = 0; i < N / 4; i++) {
				makeString();
				char last = list.remove(N - 1);
				list.add(0, last);
			}

			// 배열로 바꿔서 정렬
			String[] password = set.toArray(new String[0]);
			Arrays.sort(password, Collections.reverseOrder());

			sb.append("#").append(tc).append(" ").append(Integer.parseInt(password[K - 1], 16)).append("\n");
		}

		System.out.println(sb);
	}

	static void makeString() {
		StringBuilder sb;
		for (int i = 0; i < N; i += N / 4) {
			sb = new StringBuilder();
			for (int j = i; j < i + N / 4; j++) {
				sb.append(list.get(j));
			}
			set.add(String.valueOf(sb));
		}
	}
}
