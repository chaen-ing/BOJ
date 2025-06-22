package boj11047;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 동전 종류 개수
        int K = Integer.parseInt(st.nextToken());   // 만들어야하는 가치의 합

        int[] value = new int[N];   // 동전의 가치 배열

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;

        // greedy
        // 배열의 끝에서부터(내림차순) 가장 큰 가치의 동전을 뺄 수 있으면 뺸다
        for (int i = N - 1; i > -1; i--) {
            if (value[i] <= K) {
                K -= value[i];
                sum++;
                i++;
            }
        }

        System.out.println(sum);

    }
}
