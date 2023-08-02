package boj1904;
import java.io.*;

public class Main {
    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 길이 입력받기

        long[]arr = new long[N+1];

        arr[1] = 1;

        for(int i = 1; i <= N; i++){    // 피보나치
            if(i == 1)
                arr[1] = 1;
            else if(i == 2)
                arr[2] = 2;
            else
                arr[i] = (arr[i-2] + arr[i-1]) % 15746; // 나머지로 저장해줘야함
        }

        System.out.println(arr[N]);


    }


}
