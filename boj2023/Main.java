package boj2023;

import java.io.*;
import java.util.*;

public class Main {
	static int n;

	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		dfs(2,1);
		dfs(3,1);
		dfs(5,1);
		dfs(7,1);
	}

	// position : 자릿수
	private static void dfs(int num, int position){
		if(position == n){
			System.out.println(num);
			return;
		}

		for(int i = 1; i < 10; i += 2){
			int k = num * 10 + i;
			if(checkPrime(k)){
				dfs(k, position + 1);
			}
		}

	}

	// 소수 체크
	private static boolean checkPrime(int num){
		int sqrt = (int) Math.sqrt(num);
		for(int i = 3; i <= sqrt; i++){
			if (num % i == 0) return false;
		}
		return true;
	}
}
