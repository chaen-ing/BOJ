package boj1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int [] arr = new int [N];
		boolean [] visited = new boolean [N];

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		if(N == 1){
			System.out.println(arr[0]);
			return;
		}

		int sum = 0;
		int position = 0;

		// 음수
		for(int i = 0; i < N; i++){
			int a = arr[i];

			// 음수인 경우 다음 것 까지 비교
			if(a < 0 && i != N -1){
				int b = arr[i+1];
				if(b <= 0){
					sum += a * b;
					i++;
				}else{
					sum += a;
				}
			} else if (a == 0){	// 0인 경우 그냥 더하기
				sum += a;
			} else {	// 양수인 경우
				position = i;
				break;
			}
		}

		// 양수
		for(int i = N - 1; i >= position; i--){
			int a = arr[i];

			if(i != position){
				int b = arr[i - 1];
				if(a == 1 || b == 1){
					sum += a + b;
				}else{
					sum += a * b;
				}
				i --;
			}else{
				sum += a;
			}
		}

		System.out.println(sum);



	}
}
