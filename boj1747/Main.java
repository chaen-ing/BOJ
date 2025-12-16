package boj1747;

import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		boolean [] arr = new boolean [1003002];
		arr[0] = true;
		arr[1] = true;


		for(int i = 2; i < arr.length; i++){
			// 소수인 경우
			if(!arr[i]){
				// 합성수 판정
				for(int j = i; j < arr.length; j += i){
					arr[j] = true;
				}

				// 팰린드롬 판정
				if(i >= N){
					boolean flag = true;

					String str = String.valueOf(i);
					for(int j = 0; j < str.length() / 2; j++){
						if(str.charAt(j) != str.charAt(str.length() -1 - j)){
							flag = false;
						}
					}

					if(flag){
						System.out.println(i);
						return;
					}
				}
			}
		}


	}
}
