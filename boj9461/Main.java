package boj9461;
import java.io.*;


public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        while(T-->0){
            int N = Integer.parseInt(br.readLine());

            long [] maxL = new long [N];

            for(int i = 0; i < N; i++){
                if(i <= 2)  //  인덱스 0-2는 1
                    maxL[i] = 1;
                else if (i <= 4)    // 인덱스 3,4는 2
                    maxL[i] = 2;
                else{
                    maxL[i] = maxL[i-5] + maxL[i-1];
                }
            }

            System.out.println(maxL[N-1]);
        }

    }
}
