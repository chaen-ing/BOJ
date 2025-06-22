package boj11509;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 풍선 갯수

        int [] ballons = new int [1000002]; // 정수 N : 1 <= N <= 1,000,000

        int arrows = 0;

        st = new StringTokenizer(br.readLine());

        while(N-->0){
            int h = Integer.parseInt(st.nextToken());
            if(ballons[h+1] >= 1){    // 풍선의 높이보다 1 높은 위치에 화살이 있을 때 (한개이상 있을수도 있다)
                ballons[h+1]--;
                ballons[h]++;
            }
            else{   // 풍선을 쏠 화살이 없을떄 : 화살 개수 추가
                arrows++;
                ballons[h]++;
            }
        }

        System.out.println(arrows);

    }
}
