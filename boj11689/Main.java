package boj11689;

import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		long res = n;
		for (long i = 2; i * i <= n; i++) {
			// 소인수인 경우
			if(n % i == 0){
				while(n % i == 0){
					n /= i;
				}

				res = res / i * (i - 1);
			}
		}

		if(n > 1){
			res = res / n * (n - 1);
		}

		System.out.println(res);
	}

}
