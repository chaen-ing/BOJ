package boj1850;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long max, min;
		if(a > b){
			max = a;
			min = b;
		}else{
			max = b;
			min = a;
		}
		// 여기까지가 초기화

		// 유클리드 호제법
		while(max % min != 0){
			long temp = max;
			max = min;
			min = temp % min;
		}

		String str = "1".repeat((int) min);

		System.out.println(str);

	}


}
