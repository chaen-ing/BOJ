package boj2018;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if(n == 1){
			System.out.println(1);
			return;
		}

		int [] arr = new int [n];
		for(int i = 0; i < n; i++){
			arr[i] = i+1;
		}

		int count = 1;	// n과 동일한 경우

		int startPointer = 0;
		int endPointer = 1;
		int sum = arr[0] + arr[1];

		while(startPointer != endPointer){
			if(sum == n){
				count++;
				endPointer++;
				sum += arr[endPointer];
			}else if (sum < n){
				endPointer++;
				sum += arr[endPointer];
			}else{
				startPointer++;
				sum -= arr[startPointer-1];
			}
		}

		System.out.println(count);
	}
}
