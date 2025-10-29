package boj1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [] distance;
	static ArrayList<Tree>[] arrayList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());
		distance = new int [V+1];
		arrayList = new ArrayList [V+1];

		// ArrayList 배열의 각 인덱스 초기화!
		for(int i = 1; i <= V; i++){
			arrayList[i] = new ArrayList<>();
		}

		// 초기화
		for(int i = 0; i < V; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = Integer.parseInt(st.nextToken());

			while(true){
				int leaf = Integer.parseInt(st.nextToken());
				if(leaf == -1)	break;
				int length = Integer.parseInt(st.nextToken());

				arrayList[root].add(new Tree(leaf, length));
			}
		}

		// 임의의 점에서 가장 멀리 있는 점은 트리의 지름의 양끝점 중 하나
		clearDistance(V);
		bfs(1,V);
		int point1 = 0;
		int maxDist = 0;
		for(int i = 1; i <= V; i++){
			if(maxDist < distance[i]){
				maxDist = distance[i];
				point1 = i;
			}
		}
		distance = new int [V+1];

		// 지름의 한쪽점에서 가장 먼 점 찾기
		clearDistance(V);
		bfs(point1, V);
		maxDist = 0;
		for(int dist : distance){
			if(dist > maxDist) maxDist = dist;
		}

		System.out.println(maxDist);
	}

	static void bfs(int start, int V){
		Queue<Tree> queue = new LinkedList<>();
		distance[start] = 0;

		// 시작점
		for (int i = 0; i < arrayList[start].size(); i++){
			Tree tree = arrayList[start].get(i);
			queue.offer(arrayList[start].get(i));
			distance[tree.node] = tree.dist;
		}

		while(!queue.isEmpty()){
			Tree top = queue.poll();
			int topNode = top.node;
			int topDist = top.dist;

			for(int i = 0; i < arrayList[topNode].size(); i++){
				Tree tmp = arrayList[topNode].get(i);
				int tmpNode = tmp.node;
				int tmpDist = tmp.dist;

				if(distance[tmpNode] != -1)	continue;

				distance[tmpNode] = topDist + tmpDist;
				queue.offer(new Tree(tmpNode, topDist + tmpDist));
			}
		}
	}

	static void clearDistance(int V){
		for(int i = 1; i <= V; i++){
			distance[i] = -1;
		}
	}
}

class Tree{
	int node, dist;

	Tree(int node, int dist){
		this.node = node;
		this.dist = dist;
	}
}
