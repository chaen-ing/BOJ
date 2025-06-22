package boj16953;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> q = new LinkedList<>();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        q.offer(new Node(A,cnt));   // 첫번째 노드를 큐에 넣기

        while(!q.isEmpty()){    // 큐가 공백이 될때까지
            Node node = q.poll();

            if(node.num > B)    //  노드가 최대값을 초과했을 때
                continue;

            else if(node.num == B){ // A->B 만족시
                System.out.println(node.cnt);
                return;
            }

            else{
                q.offer(new Node(node.num*2,node.cnt+1));  // 2를 곱한수
                q.offer(new Node(node.num*10+1,node.cnt+1));  // 1을 오른쪽에 추가한 수
            }
        }

        System.out.println(-1);
    }
}
class Node{
    long num;
    int cnt;

    Node(long num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}
