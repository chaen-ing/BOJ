package boj2609;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = getGCD(A,B);
        System.out.println(gcd);
        System.out.println(A*B/gcd);

    }

    // 최소공약수 구하기
    // 유클리드 호제법
    static int getGCD(int A, int B){
        int temp;
        // 만약 A가 B보다 작을시 바꿔줌
        if(A < B){
            temp = A;
            A = B;
            B = temp;
        }

        int euclid = 1;
        while(A % B != 0){
            euclid = A % B;
            A = B;
            B = euclid;
        }

        return B;
    }
}
