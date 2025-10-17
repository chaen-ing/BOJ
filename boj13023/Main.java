package boj13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> [] arrayList;
	static boolean [] visited;
	static boolean arrived;

	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());	// 친구 수
		int m = Integer.parseInt(st.nextToken());	// 관계 수

		arrayList = new ArrayList [n];
		visited = new boolean [n];
		for (int i = 0; i < n; i++) {
			arrayList[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arrayList[a].add(b);
			arrayList[b].add(a);
		}

		for(int i = 0; i < n; i++){
			dfs(i,1);
			if(arrived){
				break;
			}
		}

		if(arrived){
			System.out.println(1);
		}else{
			System.out.println(0);
		}
	}

	private static void dfs(int now, int depth){
		if(depth == 5 || arrived){
			arrived = true;
			return;
		}

		visited[now] = true;
		for(int i : arrayList[now]){
			if(!visited[i]){
				dfs(i, depth + 1);
			}
		}

		visited[now] = false;
		// 이게 중요 !! 해당 재귀가 더 이상 진행이 불가하다면 다른 재귀 흐름에서 사용할 수 있도록 visited를 다시 돌려놔야함
	}
}
