package boj18352;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		// 초기화
		ArrayList<Integer> [] arr = new ArrayList [n + 1];
		for(int i = 1; i <= n; i++){
			arr[i] = new ArrayList<>();
		}
		int [] visited = new int [n + 1];

		while (m --> 0){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());

			arr[start].add(Integer.parseInt(st.nextToken()));
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		while(!queue.isEmpty()){
			int top = queue.poll();

			if(visited[top] > k){
				break;
			}

			for(int i = 0; i < arr[top].size(); i++){
				int tmp = arr[top].get(i);
				if(visited[tmp] == 0){
					queue.offer(tmp);
					visited[tmp] = visited[top] + 1;
				}
			}
		}

		boolean flag = false;
		for(int i = 1; i <= n; i++){
			if(i == x) continue;
			if(visited[i] == k){
				System.out.println(i);
				flag = true;
			}
		}

		if(!flag){
			System.out.println(-1);
		}


	}
}
