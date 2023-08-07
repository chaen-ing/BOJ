package boj1931;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 회의의 수

        // time[][0] : 시작 시간
        // time[][1] : 종료 시간
        int[][] time = new int[N][2];

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());  // 시작
            time[i][1] = Integer.parseInt(st.nextToken());  // 끝
        }

        // 종료 시간이 빠른 순으로 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){ // 종료시간이 같은 경우 시작 시간이 빠른순 정렬
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];   // 양수인 경우 즉, o1의 종료시간이 o2의 종료시간보다 늦은 경우 바꿈
            }
        });

        int cnt = 1;
        int end = time[0][1];

        for(int i = 1; i < N; i++){
            if(time[i][0]>= end){   // 시작시간이 현재 종료시간보다 같거나 늦은경우 작업에 추가
                cnt++;
                end = time[i][1];
            }
        }

        System.out.println(cnt);
    }
}
