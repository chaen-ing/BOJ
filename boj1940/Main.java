package boj1940;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());	// 재료의 개수
		int m = Integer.parseInt(br.readLine());	// 필요한 수 (즉, 합)

		// 초기화 및 정렬
		int [] arr = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		if(n == 1){
			System.out.println(0);
			return;
		}

		int startPointer = 0;
		int endPointer = n-1;
		int sum = arr[startPointer] + arr[endPointer];
		int count = 0;

		// 투 포인터
		while (startPointer != endPointer) {
			if(sum < m){
				startPointer++;
			}else if(sum > m){
				endPointer--;
			}else{
				count++;
				endPointer--;
			}
			sum = arr[startPointer] + arr[endPointer];
		}

		System.out.println(count);

	}
}
