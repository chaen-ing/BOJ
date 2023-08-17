package boj15681;
import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] cnt;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // N : 정점의 수
        int R = Integer.parseInt(st.nextToken());   // R : 루트 넘버
        int Q = Integer.parseInt(st.nextToken());   // Q : 쿼리의 수

        cnt = new int[N+1];
        tree = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){    // N-1개 간선 초기화
            st = new StringTokenizer(br.readLine());

            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            tree[U].add(V); // 방향 없는 그래프
            tree[V].add(U);
        }

        dfs(R,-1);

        while(Q-->0){
            int q = Integer.parseInt(br.readLine());
            System.out.println(cnt[q]);
        }

    }

    static void dfs(int currentNode, int parent){
        cnt[currentNode] = 1;

        for(int node : tree[currentNode]){
            if(node == parent)
                continue;
            dfs(node,currentNode);
            cnt[currentNode] += cnt[node];
        }
    }

}
