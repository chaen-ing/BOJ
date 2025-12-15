package boj1456;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		// b의 최대값이 10^14지만 실제로 답은 10^7 이하에서 나옴 -> 즉 int 자료형
		double max = Math.sqrt(b);
		boolean [] arr = new boolean [(int)max + 1];

		arr[0] = true;
		arr[1] = true;

		int num = 2;
		int cnt = 0;
		while(true){

			if(num > max){
				System.out.println(cnt);
				return;
			}

			// 소수인 경우
			if(!arr[num]){
				// 배수 제거
				for(int i = num; i <= max; i += num){
					arr[i] = true;
				}

				// 거의 소수 갯수 구하기
				int square = 2;
				while(true) {
					if (Math.pow(num, 2) > b) {
						System.out.println(cnt);
						return;
					} else if(Math.pow(num,square) < a){
						square++;
					} else if (Math.pow(num, square) <= b && Math.pow(num, square) >= a) {
						cnt++;
						square++;
					}
					else {
						break;
					}
				}
			}

			num++;
		}

	}
}
