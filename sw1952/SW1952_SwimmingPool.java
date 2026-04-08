package sw1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW1952_SwimmingPool {
	static int[] price;
	static int[] plan;
	static int[] monthCost;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			monthCost = new int[13];
			dp = new int[13];

			for (int i = 1; i <= 12; i++) {
				monthCost[i] = Math.min(price[0] * plan[i - 1], price[1]);
			}

			for (int i = 1; i <= 12; i++) {
				dp[i] = dp[i - 1] + monthCost[i];	// 지난달 + 이번달

				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i - 3] + price[2]);
				} else {
					dp[i] = Math.min(dp[i], price[2]);
				}
			}

			int res = Math.min(dp[12], price[3]);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}

		System.out.println(sb);
	}
}