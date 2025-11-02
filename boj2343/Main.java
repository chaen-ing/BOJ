package boj2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	public static void main(String []args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int [N];
		int max = 0;	// 모든 크기의 합 : 최악의 경우
		int min = 0;	// 가장 큰 단일 값 : 최선의 경우?
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			int tmp = Integer.parseInt(st.nextToken());
			arr[i] = tmp;
			if(tmp > min) min = tmp;
			max += tmp;
		}

		while(min <= max){
			int middle = (min + max) / 2;	// 현재 블루레이 크기
			int sum = 0;
			int cnt = 0;

			for(int i = 0; i < N; i++){
				// 블루레이 크기를 초과하게 되면 개수 하나 더 사용
				if(sum + arr[i] > middle){
					cnt++;
					sum = 0;
				}
				sum += arr[i];
			}

			// sum이 0이 아니면 마지막 블루레이 값 +1
			if(sum != 0)	cnt++;

			// 이분 탐색 부분
			// 블루레이 수 보다 많다 -> 블루레이 크기 늘려야함 -> 최소값을 늘림
			if(cnt > M)	min = middle + 1;
			// 블루레이 수 보다 적거나 같다 -> 블루레이 크기 줄여야함 -> 최대값을 줄임
			else	max = middle - 1;

		}
		System.out.println(min);
	}
}
