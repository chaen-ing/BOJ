package boj1629;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a,b,c));
    }

    public static long pow(long a, long exponent, long c){
        if(exponent == 1){
            return a % c;
        }

        long temp = pow(a, exponent/2, c);

        if(exponent % 2 == 1){  // 지수가 홀수면 한번 더 곱해주는 과정 추가
            return (temp * temp % c) * a % c;
        }
        return temp * temp % c; // temp는 a % c이므로 모듈러 공식을 이용한 것
    }
}
