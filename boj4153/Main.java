package boj4153;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            int a = (int) Math.pow(Integer.parseInt(st.nextToken()),2);
            int b = (int) Math.pow(Integer.parseInt(st.nextToken()),2);
            int c = (int) Math.pow(Integer.parseInt(st.nextToken()),2);

            if(a == 0) break;

            // 직각 삼각형 판정
            if((a == b + c) ||(b == a + c) || (c == a + b)){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }

    }
}
