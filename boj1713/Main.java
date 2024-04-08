package boj1713;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node> arrayList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());

            // 이미 있는지 체크
            boolean containFlag = false;
            for (Node node : arrayList) {
                if (node.num == num) {
                    node.recommend += 1;
                    containFlag = true;
                    break;
                }
            }

            // 없을 경우
            if(!containFlag){
                if(arrayList.size() < N){  // 빈 자리 O
                    arrayList.add(new Node(num,1,i));
                }else {  // 빈 자리 X
                    Collections.sort(arrayList);
                    arrayList.remove(0);
                    arrayList.add(new Node(num, 1, i));
                }
            }
        }

        int [] studentNum = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++){
            studentNum[i] = arrayList.get(i).num;
        }

        Arrays.sort(studentNum);
        for(int i = 0; i < studentNum.length; i++){
            System.out.print(studentNum[i]+" ");
        }


    }
}

class Node implements Comparable<Node>{
    int num, recommend, time;

    public Node(int num, int recommend, int time) {
        this.num = num;
        this.recommend = recommend;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        if(this.recommend > o.recommend)    return 1;
        else if(this.recommend == o.recommend){
            return this.time - o.time;
        }else return -1;
    }


}
