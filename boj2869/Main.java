package boj2869;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        /*
        a-b씩 증가 하다가 마지막 날은 a만큼 증가
        n(a-b) + a >= v
        여기서 구한 값에 +1
         */

        int day = (int)Math.ceil(((double)V-A)/((double)A-B))+1;

        System.out.println(day);
    }
}
