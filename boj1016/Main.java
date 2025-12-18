package boj1016;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		boolean[] check = new boolean[(int)(max - min + 1)];

		// 2부터 i의 제곱이 max보다 작을때까지 진행
		for (long i = 2; i * i <= max; i++) {
			// 제곱수
			long square = i * i;

			// min이상인 square의 첫번쨰 배수 구함
			long start = ((min + square - 1) / square) * square;

			// start로부터 square의 모든 배수 true 처
			for (long j = start; j <= max; j += square) {
				check[(int)(j - min)] = true;
			}
		}

		int cnt = 0;
		for (boolean b : check) {
			if (!b) cnt++;
		}

		System.out.println(cnt);
	}


}
