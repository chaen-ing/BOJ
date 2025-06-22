package boj9093;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        StringBuffer sbf;

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){  // 남은 토큰이 있을때까지
                sbf = new StringBuffer(st.nextToken());
                sb.append(sbf.reverse().toString()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
