package boj10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());	// 1 <= N <= 10^6
		int M = Integer.parseInt(st.nextToken());	// 2 <= M <= 10^3
		int [] sumArr = new int [N];	// (구간합 / M)의 나머지 저장
		int [] countArr = new int [M];	// 각 나머지의 개수 저장
		long sum = 0;

		st = new StringTokenizer(br.readLine());

		// 0번째 초기화
		int k = (int)(Long.parseLong(st.nextToken()) % M);
		sumArr[0] = k;
		if(k == 0) sum++;
		countArr[k]++;
		// 초기화
		for(int i = 1 ; i < N; i++){
				long input = Long.parseLong(st.nextToken());
				k = (int)((sumArr[i-1] + input) % M);
				sumArr[i] = k;
				if (k == 0) sum++;
				countArr[k]++;
		}

		for(int i = 0; i < M; i++){
			int c = countArr[i];
			if(c > 1){	// 없거나 1개일때는 제외
				sum += (long)c * (c-1) / 2;
			}
		}

		System.out.println(sum);
	}
}
