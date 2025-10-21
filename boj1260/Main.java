package boj1260;
import java.io.*;
import java.util.*;

public class Main {
    static boolean visited [];
    static ArrayList<Integer>[] arrayList;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
		int v = Integer.parseInt(st.nextToken()); // 시작 정점

		arrayList = new ArrayList[n+1];
		for (int i = 0; i < n + 1; i++) {
			arrayList[i] = new ArrayList<Integer>(); // 링크드 리스트 n개를 리스트에 추가
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arrayList[a].add(b);
			arrayList[b].add(a);
		}

		for (int i = 1; i <= n; i++) { // 오름차순 정렬
			Collections.sort(arrayList[i]);
		}

		visited = new boolean[n+1];
        dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		bfs(v);
	}

	private static void bfs(int node) {
        Queue <Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		visited[node] = true;

		while(!queue.isEmpty()){
			int top = queue.poll();
			System.out.print(top+" ");
			for(int i : arrayList[top]){
				if(!visited[i]){
					visited[i] = true;
					queue.add(i);
 				}
			}
		}
	}

	private static void dfs(int node){
		System.out.print(node + " ");
		visited[node] = true;

		for(int i : arrayList[node]){
			if(!visited[i]){
				dfs(i);
			}
		}
	}

	private static void firstTry() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
		int v = Integer.parseInt(st.nextToken()); // 시작 정점

		arrayList = new ArrayList[n + 1];

		visited = new boolean[n + 1]; // 방문여부 체크, 디폴트가 false

		for (int i = 0; i < n + 1; i++) {
			arrayList[i] = new ArrayList<>(); // 링크드 리스트 n개를 리스트에 추가
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arrayList[a].add(b); // a라는 연결리스트를 가져와 b를 추가
			arrayList[b].add(a);
			 // 양방향 그래프이므로 둘다 추가

		}

		for (int i = 1; i < n+1; i++) { // 오름차순 정렬
			Collections.sort(arrayList[i]);
		}

		for (int i = 1; i < n + 1; i++) { // 끝을 표현해주기위해 연결리스트의 마지막에는 0 삽입
			arrayList[i].add(0);
		}

		dfss(v, m);
		System.out.println();
		visited = new boolean[n+1]; // 방문여부 체크 배열 초기화
		bfss(v);
	}

	static void dfss(int v, int m){ // 깊이 우선 탐색. 스택으로 구현
        Stack<Integer> stack = new Stack<>();
        visited[v] = true;
        stack.push(v);
        System.out.print(v+" ");

        int num;
        while(!stack.isEmpty()) {
			for (int i = 0; i <= m; i++) {
				num = arrayList[v].get(i);
				if (num == 0) { // 인접노드가 없을때
					stack.pop();
					if (stack.isEmpty()) { // 스택이 공백이 되면 종료
						return;
					}
					v = stack.peek();
					i = -1;
				} else if (!visited[num]) { // 인접노드가 있고 방문하지 않은 노드일때 -> 해당 노드로 이동해서 0번부터 탐색
					visited[num] = true;
					stack.push(num);
					System.out.print(num + " ");
					v = num;
					i = -1;
				}
			}
		}
    }

    static void bfss(int v){ // 너비 우선 탐색. 큐로 구현
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true; // 시작 노드
        queue.offer(v);
        System.out.print(v+" ");

        int num;
        while(!queue.isEmpty()){
            for(int i = 0; i < arrayList[v].size(); i++){
                num = arrayList[v].get(i);
                if(num == 0){ // 더 이상 인접노드가 없을때
                    queue.poll();
                    if(queue.isEmpty()){ // 인접노드도 없고, 큐도 공백이 되면 종료
                        return;
                    }
                    v = queue.peek();
                    i = -1;
                    // 다음 노드로 이동
                }
                else if(!visited[num]){ // 방문하지 않은 노드일때 방문 -> 해당 노드의 형제노드 모두 탐색
                    visited[num] = true;
                    queue.offer(num); // 큐에 넣기
                    System.out.print(num+" ");
                }
            }
        }
    }
}


