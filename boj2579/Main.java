package boj2579;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 총 계단 수

        int []stairs = new int[n+1];  // 계단에 있는 숫자 정보 저장
        int []score = new int[n+1];   // 계단 별 최대 점수 저장

        for(int i = 1; i <= n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        score[1] = stairs[1];

        for(int i = 2; i <= n; i++){
            if(i == 2)
                score[2] = stairs[1] + stairs[2];
            else{
                //  현재 위치에서 1칸 전 값 + 3칸 전 최대값 + 현재 값(1칸전꺼는 연속이 될 가능성이 있으므로 그전것까지 신경써줘야함)
                //  또는, 현재 위치에서 2칸 전 최대값 + 현재 값
                score[i] = Math.max(stairs[i-1] + score[i-3], score[i-2]) + stairs[i];
            }
        }

        System.out.println(score[n]);


    }
}
