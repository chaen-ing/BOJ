package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apt {
	public static void main(String[] args) throws IOException {
		// 층 수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if (n == 1)
			System.out.println(2);
		else if (n == 2)
			System.out.println(3);
		else
			System.out.println(calc(n, 2, 2, 3));

	}

	static int calc(int n, int cnt, int first, int scd) {
		if (cnt == n)
			return scd;
		return calc(n, cnt + 1, scd, first + scd);
	}
}
