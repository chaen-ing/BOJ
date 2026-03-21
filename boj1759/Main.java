package boj1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] alpha;
	static char[] res;
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alpha = new char[C];
		res = new char[L];
		String[] line = br.readLine().split(" ");
		for (int i = 0; i < line.length; i++) {
			alpha[i] = line[i].charAt(0);
		}

		Arrays.sort(alpha);

		comb(0, 0);

		System.out.println(stringBuilder);
	}

	// 조합 : 뒤에것만 고르기
	static void comb(int cnt, int start) {
		if (cnt == L) {
			// 모음 개수 체크
			int vowel = 0;
			for (char c : res) {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					vowel++;
			}
			if (vowel < 1 || L - vowel < 2)
				return;

			for (char c : res) {
				stringBuilder.append(c);
			}
			stringBuilder.append("\n");
			return;
		}

		for (int i = start; i < C; i++) {
			res[cnt] = alpha[i];    // cnt : 0 ~ 3
			comb(cnt + 1, i + 1);
		}
	}
}
