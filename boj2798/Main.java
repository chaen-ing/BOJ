package boj2798;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 카드 개수
        int M = Integer.parseInt(st.nextToken());   // 최대 값

        st = new StringTokenizer(br.readLine());
        int [] cards = new int[N];

        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int blackJack = 0;
        for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = cards[i] + cards[j] + cards[k];
                    if(sum <= M && sum > blackJack) blackJack = sum;    // 최대값을 넘지않고 가장 가까운 수
                }
            }
        }

        System.out.println(blackJack);
    }
}
