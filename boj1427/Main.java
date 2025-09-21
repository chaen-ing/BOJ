package boj1427;

import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 초기화
		char[] charArr = br.readLine().toCharArray();
		int [] arr = new int [charArr.length];
		for(int i = 0; i < charArr.length; i++){
			arr[i] = charArr[i] - '0';
		}

		// 선택 정렬
		for(int i = 0; i < arr.length; i++){
			int max = -1;
			int idx = 0;

			// 최대값 찾기
			for(int j = i; j < arr.length; j++){
				if(arr[j] > max){
					max = arr[j];
					idx = j;
				}
			}

			arr[idx] = arr[i];
			arr[i] = max;
		}


		for(int i = 0 ; i < arr.length; i++){
			System.out.print(arr[i]);
		}



	}
}
