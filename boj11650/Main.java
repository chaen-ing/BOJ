package boj11650;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        PriorityQueue<Node> map = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 점의 개수

        while(N-->0){   // 큐에 좌표 노드 저장
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.offer(new Node(x,y));
        }

        while(!map.isEmpty()){
            Node node = map.poll();
            System.out.println(node.x+" "+node.y);
        }


    }
}

class Node implements Comparable<Node>{
    public int x,y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node node) {
        if (this.x == node.x)    // x가 같으면 y비교해서 리턴
            return this.y - node.y;
        return this.x - node.x; // 더크면 양수, 작으면 음수가 자동으로 리턴
    }
}
