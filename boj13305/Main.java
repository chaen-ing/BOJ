package boj13305;
import java.util.*;
import java.io.*;

public class Main {
    static long[] length;
    static long[] price;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 도시 개수

        length = new long[N-1];    // 도로길이
        price = new long[N];    // 리터당 가격

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++){
            length[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }


        System.out.println(greedy(N));

    }
    static long greedy(int N){
        long sum = 0;

        for(int i = 0; i < N-1; i++){
            sum += length[i] * price[i];

            for(int j = i+1; j < N; j++){   // 자기보다 싼 주유소가 나오기 전까지 구매
                if(j == N-1){   // 마지막 노드 도달시 종료
                    return sum;
                }
                if (price[i] < price[j]){
                    sum += price[i] * length[j];
                }
                else{
                    i = j-1;
                    break;
                }
            }
        }
        return sum;
    }
}
