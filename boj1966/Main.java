package boj1966;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> queue= new LinkedList<>(); // Node로 구성된 큐
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){ // n번 반복
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // num : 문서에 있는 자료 개수
            int findIdx = Integer.parseInt(st.nextToken()); // findIdx : 몇번째로 출력되는지 알아야하는 파일의 인덱스
            Integer[] arr = new Integer[num];

            // 큐에 원소 삽입 및 최대값 설정
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < num; j++){
                int token = Integer.parseInt(st.nextToken());
                //System.out.println(token);
                queue.offer(new Node(token,j)); // node의 value, idx에 각각 값 넣기
                arr[j] = token;
            }
            Arrays.sort(arr, Collections.reverseOrder());

            int count = 1;
            for(int j = 0; j < num; j++){
                int max = arr[j]; // 최대값
                Node node  = queue.poll(); // back에 있는 노드

                while(node.value != max){ // 최대 가중치 값이 back에 있도록 조정
                    queue.offer(node);
                    node = queue.poll();
                }

                if(node.idx == findIdx){ // 출력하려고 한 인덱스가 back이면 count 출력하고 종료
                    System.out.println(count);
                    break;
                }
                else{ // 아니면 count만 증가시킴
                    count++;
                }
            }
            queue.clear(); // 다음 입력을 위해 큐 초기화
        }
    }
}
class Node{ // 중요도와 처음 인덱스를 같이 알고 있어야함
    int value, idx;

    public Node(int value, int idx){ // 생성자
        this.value = value;
        this.idx = idx;
    }
}
