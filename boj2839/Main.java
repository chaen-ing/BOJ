package boj2839;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 배달해야하는 설탕 kg

        int num = 0;    // 봉지개수

        while(true){
            if(N == 0){   // 3의 배수인 경우
                System.out.println(num);
                return;
            }

            if(N == 1 || N == 2){   // 마지막에 1이나 2가 남으면 정확하게 Nkg 만들 수 없는 것 의미
                System.out.println(-1);
                return;
            }

            if(N % 5 == 0){ // 5로 나누어 떨어질 시에는 출력후 종료
                num += N / 5;
                System.out.println(num);
                return;
            }

            N -= 3; // 5로 나누어떨어지지 않을시 3을 뺀 후 다시 반복
            num++;
        }


    }

}
