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

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public int compareTo(Node node){
        if(this.x < node.getX())   // 자신보다 값이 작을때
            return -1;

        else if(this.x > node.getX())    // 자신보다 값이 클때
            return 1;

        else{   // 값이 같을 때
            if(this.y < node.getY())
                return -1;
            else if(this.y > node.getY())
                return 1;
        }

        return 0;
    }
}
