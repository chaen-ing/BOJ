package boj11660;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());	// 배열 크기
		int M = Integer.parseInt(st.nextToken());	// 질문 개수
		int [][] arr = new int[N][N];
		int [][] sumArr = new int[N][N];

		// 초기화
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				int k = Integer.parseInt(st.nextToken());
				arr[i][j] = k;
				if(j == 0){
					sumArr[i][j] = k;
				}else{
					sumArr[i][j] = sumArr[i][j-1] + k;
				}
			}
		}


		while(M --> 0){
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;

			// 동일한 범위 : 배열의 값
			if(x1 == x2 && y1 == y2){
				bw.write(arr[x1][y1] + "\n");
			}
			// 열이 동일
			else if(y1 == y2){
				int sum = 0;
				for(int i = x1; i <= x2; i++){
					sum += arr[i][y1];
				}
				bw.write(sum + "\n");
			}
			// 행이 동일 또는 둘다 다를때
			else{
				int sum = 0;
				for(int i = x1; i <= x2; i++){
					if(y1 == 0){
						sum += sumArr[i][y2];
					}else{
						sum += sumArr[i][y2] - sumArr[i][y1-1];
					}
				}
				bw.write(sum + "\n");
			}
		}

		bw.flush();


	}
}
