package boj10816;
import java.io.*;
import java.util.*;

public class Main {
    static int[] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 갖고있는 카드 갯수
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 카드 배열 저장
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards); // 이분탐색을 위해 배열 정렬

        int M = Integer.parseInt(br.readLine());    // 확인할 숫자 갯수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) { // 카드 배열 저장
            int card = Integer.parseInt(st.nextToken());

            sb.append(upperBound(card) - lowerBound(card));
            sb.append(' ');
        }

        System.out.println(sb);
    }

    static int lowerBound(int key){
        int low = 0;
        int high = cards.length;
        int mid;

        while(low < high){
            mid = (low + high) / 2;

            if(cards[mid] < key)
                low = mid + 1;
            else    // key와 mid가 같을때는 high를 줄임 -> 중복 원소에 대해 왼쪽으로 탐색하도록
                high = mid;
        }

        return low;
    }

    static int upperBound(int key){
        int low = 0;
        int high = cards.length;
        int mid;

        while(low < high){
            mid = (low + high) / 2;

            if(cards[mid] <= key)  // key와 mid가 같을때는 low를 늘림 -> 중복 원소에 대해 오른쪽으로 탐색하도록
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }


}
