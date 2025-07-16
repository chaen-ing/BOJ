package boj1253;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 배열 초기화 및 정렬
		StringTokenizer st = new StringTokenizer(br.readLine());
		long [] arr = new long [n];
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		// 수가 2개 이하면 좋은 수 X
		if(n <= 2){
			System.out.println(0);
			return;
		}

		int count = 0;

		// 모든 수에 대해 체크
		// 첫번째수도 가능하다 ex) 0, 0, 0
		// 두번째수도 당연히 가능 ex) -50, 0, 50
		for(int i = 0; i < n; i++){
			int startPointer = 0;
			int endPointer = n - 1;
			long temp = arr[i];

			// 현재 체크중인 수에 대해서 좋은 수 인지 여부 판단
			while(startPointer != endPointer){
				// 자기 자신은 제외
				if(endPointer == i) endPointer--;
				if(startPointer == i) startPointer++;

				// 포인터 이동했으므로 한번 더 체크
				if(startPointer == endPointer){
					break;
				}
				if(endPointer < 0 || startPointer >= n){
					break;
				}

				long sum = arr[startPointer] + arr[endPointer];
				if(temp < sum){
					endPointer--;
				}else if(temp > sum){
					startPointer++;
				}else{	// 좋은 수 일 경우 카운트 올리고 끝
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
