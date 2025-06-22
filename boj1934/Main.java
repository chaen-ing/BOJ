package boj1934;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println(A * B / getGCD(A,B));

        }
    }

    static int getGCD(int A, int B){
        int temp;
        if(A < B){
            temp = A;
            A = B;
            B = temp;
        }

        int euclid;
        while(A%B != 0){
            euclid = A % B;
            A = B;
            B = euclid;
        }

        return B;
    }
}
