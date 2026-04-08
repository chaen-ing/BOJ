package dp;

import java.io.IOException;

public class Fibonacci {
	static int memo[];

	public static void main(String[] args) throws IOException {

	}

	static int fibo(int n) {
		if (memo[n] != -1)
			return memo[n];
		memo[n] = fibo(n - 1) + fibo(n - 2);
		return memo[n];
	}
}
