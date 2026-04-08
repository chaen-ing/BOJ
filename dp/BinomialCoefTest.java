package dp;

public class BinomialCoefTest {
	static int N, K;

	public static void main() {
		// 행 열 입력
		int[][] B = new int[N + 1][K + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0, end = Math.min(i, K); j <= end; j++) {
				if (j == 0 || j == i)
					B[i][j] = 1;
				else
					B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
			}
		}
	}
}
