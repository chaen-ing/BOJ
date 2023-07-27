package boj1654;
import java.util.*;
import java.io.*;

public class Main {
    static int []cable;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());   // 갖고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken());   // 필요한 랜선 개수

        cable = new int[K];

        long hi = Integer.MIN_VALUE;
        long lo = 0;

        for(int i = 0; i < K; i++){
            cable[i] = Integer.parseInt(br.readLine());

            hi = Math.max(hi,cable[i]); // 최대값 저장
        }

        System.out.println(upperBound(hi,lo,N));

    }

    static long upperBound(long hi, long lo, int N){  // 최대 길이 찾아야하므로 upper bound
        // 예를 들어 lo 0, hi 1인 경우에 upper bound로 하면 1이여야하는데 mid = 0이 됨
        // 이를 방지하기 위해 hi는 최대길이 +1을 해주기
        hi += 1;

        long mid;
        long sum;

        while(lo < hi){ // lo가 hi보다 커지면 종료

            mid = lo + ((hi-lo)/2); // 오버플로 방지

            sum = cableSum(mid);    // mid로 잘랐을때 나오는 랜선 개수

            if(sum < N) // 자른 케이블의 길이가 클때 -> high를 이동
                hi = mid;
            else    // 자른 케이블의 길이가 작거나 같을때 -> low를 이동
                lo = mid + 1;

        }
        return hi-1;
    }

    static long cableSum(long l){    // 나오는 랜선 개수 구해주는 함수
        long sum = 0;

        for(int i = 0; i < cable.length; i++){
            sum += cable[i] / l;
        }

        return sum;
    }
}

