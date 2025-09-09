package boj17298;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 초기화
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Data> stack = new Stack<>();

		for(int i = 0; i < n ; i++){
			int k = arr[i];

			// 오큰수가 자기자신인 경우 : pop
			if(!stack.isEmpty() && stack.peek().oks == k) stack.pop();

			boolean find = false;

			// 비어있는 경우 : 오큰수 찾기
			if(stack.isEmpty()) {
				for (int j = i + 1; j < n; j++) {
					if (arr[j] > k) {
						stack.push(new Data(j,arr[j]));
						bw.write(arr[j]+ " ");
						find = true;
						break;
					}
				}
				// 오큰수가 없다면 스택에는 안넣고 -1
				if(!find){
					bw.write(-1 + " ");
				}
			}else if(stack.peek().index == i+1){	// 스택에 있는 오큰수가 자신보다 +1 인덱스라면 사용
				bw.write(stack.peek().oks+ " ");
			}else{	// 비어있지 않지만 다시 검사 필요
				for (int j = i + 1; j < n; j++) {
					if (arr[j] > k) {
						if(stack.peek().index != j && stack.peek().oks != arr[j]){
							stack.push(new Data(j,arr[j]));
						}
						bw.write(arr[j]+ " ");
						find = true;
						break;
					}
				}
				if(!find){
					bw.write(-1 + " ");
				}
			}
		}
		bw.flush();
	}
}

class Data{
	int index;
	int oks;

	public Data(int index, int oks){
		this.index = index;
		this.oks = oks;
	}
}
