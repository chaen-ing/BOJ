package boj17219;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, String> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 저장된 사이트 주소의 수
        int M = Integer.parseInt(st.nextToken());   // 비밀번호를 찾으려는 사이트 주소의 수

        while(N --> 0){
            st = new StringTokenizer(br.readLine());
            hashMap.put(st.nextToken(),st.nextToken());
        }

        while(M --> 0){
            bw.write(hashMap.get(br.readLine()));
            bw.newLine();
        }

        bw.flush();


    }
}
